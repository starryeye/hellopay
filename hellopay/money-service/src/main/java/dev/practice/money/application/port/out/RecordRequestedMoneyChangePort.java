package dev.practice.money.application.port.out;

import dev.practice.money.domain.RequestedMoneyChange;

public interface RecordRequestedMoneyChangePort {

    RequestedMoneyChange record(
            RequestedMoneyChange.TargetMemberId targetMemberId,
            RequestedMoneyChange.Amount amount,
            RequestedMoneyChange.Type type,
            RequestedMoneyChange.Status status,
            RequestedMoneyChange.TransactionId transactionId
    );
}
