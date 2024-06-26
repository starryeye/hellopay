package dev.practice.money.application.port.in;

import dev.practice.money.domain.RequestedMoneyChange;

public interface IncreaseMoneyUseCase {

    RequestedMoneyChange increaseMoney(
            RequestedMoneyChange.TargetMemberId memberId,
            RequestedMoneyChange.Amount amount
    );
}
