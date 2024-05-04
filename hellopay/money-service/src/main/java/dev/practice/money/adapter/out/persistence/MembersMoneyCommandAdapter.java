package dev.practice.money.adapter.out.persistence;

import dev.practice.common.PersistenceAdapter;
import dev.practice.money.adapter.out.persistence.jpa.MembersMoneyJpaEntity;
import dev.practice.money.adapter.out.persistence.jpa.MembersMoneyJpaRepository;
import dev.practice.money.application.port.out.UpdateMembersMoneyBalancePort;
import dev.practice.money.domain.MembersMoney;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembersMoneyCommandAdapter implements UpdateMembersMoneyBalancePort {

    private final MembersMoneyJpaRepository membersMoneyJpaRepository;

    @Override
    public void updateBalance(
            MembersMoney.MembersMoneyId membersMoneyId,
            MembersMoney.Balance updatedBalance
    ) {
        MembersMoneyJpaEntity entity = membersMoneyJpaRepository.findById(membersMoneyId.getMembersMoneyIdValue()).orElseThrow();

        entity.changeBalance(updatedBalance.getBalanceValue());
    }
}
