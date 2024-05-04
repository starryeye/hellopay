package dev.practice.money.adapter.out.persistence;

import dev.practice.common.PersistenceAdapter;
import dev.practice.money.adapter.out.persistence.jpa.RequestedMoneyChangeJpaEntity;
import dev.practice.money.adapter.out.persistence.jpa.RequestedMoneyChangeJpaRepository;
import dev.practice.money.application.port.out.RecordRequestedMoneyChangePort;
import dev.practice.money.domain.RequestedMoneyChange;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RequestedMoneyChangeCommandAdapter implements RecordRequestedMoneyChangePort {

    private final RequestedMoneyChangeJpaRepository requestedMoneyChangeJpaRepository;

    @Override
    public RequestedMoneyChange record(
            RequestedMoneyChange.TargetMemberId targetMemberId,
            RequestedMoneyChange.Amount amount,
            RequestedMoneyChange.Type type,
            RequestedMoneyChange.Status status,
            RequestedMoneyChange.TransactionId transactionId
    ) {

        RequestedMoneyChangeJpaEntity entity = RequestedMoneyChangeJpaEntity.create(
                targetMemberId.getTargetMemberIdValue(),
                amount.getAmountValue(),
                type.getTypeValue(),
                status.getStatusValue(),
                transactionId.getTransactionIdValue()
        );

        return requestedMoneyChangeJpaRepository.save(entity).toDomain();
    }
}
