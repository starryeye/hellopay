package dev.practice.banking.application.service;

import dev.practice.banking.application.port.in.RequestFirmBankingUseCase;
import dev.practice.banking.application.port.in.source.RequestFirmBankingSource;
import dev.practice.banking.application.port.out.RegisterRequestedFirmBankingPort;
import dev.practice.banking.application.port.out.RequestExternalFirmBankingPort;
import dev.practice.banking.application.port.out.UpdateRequestedFirmBankingPort;
import dev.practice.banking.domain.RequestedFirmBanking;
import dev.practice.banking.domain.enums.RequestedFirmBankingType;
import dev.practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class RequestFirmBanking implements RequestFirmBankingUseCase {

    private final RegisterRequestedFirmBankingPort registerRequestedFirmBankingPort;
    private final RequestExternalFirmBankingPort requestExternalFirmBankingPort;
    private final UpdateRequestedFirmBankingPort updateRequestedFirmBankingPort;


    @Transactional
    @Override
    public RequestedFirmBanking execute(RequestFirmBankingSource source) {

        // 0. aggregate 생성
        String transactionId = UUID.randomUUID().toString();

        // 1. 요청 상태의 RequestedFirmBanking 을 DB 에 저장
        RequestedFirmBanking registered = registerRequestedFirmBankingPort.register(
                new RequestedFirmBanking.RequestedMemberId(source.getRequestedMemberId()),
                new RequestedFirmBanking.FromBankName(source.getFromBankName()),
                new RequestedFirmBanking.FromBankAccountNumber(source.getFromBankAccountNumber()),
                new RequestedFirmBanking.ToBankName(source.getToBankName()),
                new RequestedFirmBanking.ToBankAccountNumber(source.getToBankAccountNumber()),
                new RequestedFirmBanking.Amount(source.getAmount()),
                new RequestedFirmBanking.RequestStatus(RequestedFirmBankingType.REQUESTED),
                new RequestedFirmBanking.TransactionId(transactionId)
        );

        // 2. 외부 은행에 firm banking 요청
        Boolean requestResult = requestExternalFirmBankingPort.request(
                new RequestedFirmBanking.FromBankName(registered.getFromBankName()),
                new RequestedFirmBanking.FromBankAccountNumber(registered.getFromBankAccountNumber()),
                new RequestedFirmBanking.ToBankName(registered.getToBankName()),
                new RequestedFirmBanking.ToBankAccountNumber(registered.getToBankAccountNumber()),
                new RequestedFirmBanking.Amount(registered.getAmount())
        );

        // 3. 외부 은행 요청 결과에 따라 요청 상태를 업데이트 (성공 or 실패)
        RequestedFirmBanking updated;
        if(requestResult == Boolean.TRUE){
            updated = updateRequestedFirmBankingPort.changeStatus(
                    new RequestedFirmBanking.RequestedFirmBankingId(registered.getRequestedFirmBankingId()),
                    new RequestedFirmBanking.RequestStatus(RequestedFirmBankingType.COMPLETED)
            );
        }else {
            updated = updateRequestedFirmBankingPort.changeStatus(
                    new RequestedFirmBanking.RequestedFirmBankingId(registered.getRequestedFirmBankingId()),
                    new RequestedFirmBanking.RequestStatus(RequestedFirmBankingType.FAILED)
            );
        }

        // 4. 결과 리턴
        return updated;
    }
}
