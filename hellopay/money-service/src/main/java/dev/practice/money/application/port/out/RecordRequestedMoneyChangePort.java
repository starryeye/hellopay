package dev.practice.money.application.port.out;

import dev.practice.money.domain.RequestedMoneyChange;

public interface RecordRequestedMoneyChangePort {

    void save(
            RequestedMoneyChange.TargetMemberId targetMemberId,
            RequestedMoneyChange.Amount amount
    );
}
