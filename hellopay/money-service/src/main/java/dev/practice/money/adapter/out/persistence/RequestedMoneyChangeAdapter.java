package dev.practice.money.adapter.out.persistence;

import dev.practice.common.PersistenceAdapter;
import dev.practice.money.application.port.out.RecordRequestedMoneyChangePort;
import dev.practice.money.domain.RequestedMoneyChange;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RequestedMoneyChangeAdapter implements RecordRequestedMoneyChangePort {


    @Override
    public void save(
            RequestedMoneyChange.TargetMemberId targetMemberId,
            RequestedMoneyChange.Amount amount
    ) {

    }
}
