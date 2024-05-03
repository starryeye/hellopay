package dev.practice.money.application.service;

import dev.practice.common.UseCase;
import dev.practice.money.application.port.in.IncreaseMoneyUseCase;
import dev.practice.money.application.port.out.RecordRequestedMoneyChangePort;
import dev.practice.money.domain.RequestedMoneyChange;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class RequestMoneyChange implements IncreaseMoneyUseCase {

    private final RecordRequestedMoneyChangePort recordRequestedMoneyChangePort;

    @Override
    public void increaseMoney(
            RequestedMoneyChange.TargetMemberId memberId,
            RequestedMoneyChange.Amount amount
    ) {

    }
}
