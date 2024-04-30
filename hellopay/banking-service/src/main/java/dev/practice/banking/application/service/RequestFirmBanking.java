package dev.practice.banking.application.service;

import dev.practice.banking.application.port.in.RequestFirmBankingUseCase;
import dev.practice.banking.application.port.in.source.RequestFirmBankingSource;
import dev.practice.banking.domain.RequestedFirmBanking;
import dev.practice.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class RequestFirmBanking implements RequestFirmBankingUseCase {



    @Override
    public RequestedFirmBanking requestFirmBanking(RequestFirmBankingSource requestFirmBankingSource) {

        // 1. 요청 상태의 RequestedFirmBanking 을 DB 에 저장
        // 2. 외부 은행에 firm banking 요청
        // 3. 외부 은행 요청 결과에 따라 요청 상태를 업데이트 (성공 or 실패)
        // 4. 결과 리턴
    }
}
