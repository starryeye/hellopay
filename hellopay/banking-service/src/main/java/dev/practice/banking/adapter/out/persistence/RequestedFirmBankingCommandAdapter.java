package dev.practice.banking.adapter.out.persistence;

import dev.practice.banking.adapter.out.persistence.jpa.RequestedFirmBankingJpaEntity;
import dev.practice.banking.adapter.out.persistence.jpa.RequestedFirmBankingJpaRepository;
import dev.practice.banking.application.port.out.RegisterRequestedFirmBankingPort;
import dev.practice.banking.application.port.out.UpdateRequestedFirmBankingPort;
import dev.practice.banking.domain.RequestedFirmBanking;
import dev.practice.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RequestedFirmBankingCommandAdapter implements RegisterRequestedFirmBankingPort, UpdateRequestedFirmBankingPort {

    private final RequestedFirmBankingJpaRepository requestedFirmBankingJpaRepository;

    @Override
    public RequestedFirmBanking register(
            RequestedFirmBanking.FromBankName fromBankName,
            RequestedFirmBanking.FromBankAccountNumber fromBankAccountNumber,
            RequestedFirmBanking.ToBankName toBankName,
            RequestedFirmBanking.ToBankAccountNumber toBankAccountNumber,
            RequestedFirmBanking.Amount amount,
            RequestedFirmBanking.RequestStatus requestStatus,
            RequestedFirmBanking.TransactionId transactionId
    ) {

        RequestedFirmBankingJpaEntity entity = RequestedFirmBankingJpaEntity.create(
                fromBankName.getFromBankNameValue(),
                fromBankAccountNumber.getFromBankAccountNumberValue(),
                toBankName.getToBankNameValue(),
                toBankAccountNumber.getToBankAccountNumberValue(),
                amount.getAmountValue(),
                requestStatus.getRequestStatusValue(),
                transactionId.getTransactionIdValue()
        );

        return requestedFirmBankingJpaRepository.save(entity).toDomain();
    }

    @Override
    public RequestedFirmBanking changeStatus(
            RequestedFirmBanking.RequestedFirmBankingId requestedFirmBankingId,
            RequestedFirmBanking.RequestStatus requestStatus
    ) {
        RequestedFirmBankingJpaEntity entity = requestedFirmBankingJpaRepository.findById(requestedFirmBankingId.getRequestedFirmBankingIdValue()).orElseThrow();

        entity.changeStatus(requestStatus.getRequestStatusValue());

        return entity.toDomain();
    }
}
