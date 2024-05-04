package dev.practice.money.adapter.out.persistence;

import dev.practice.common.PersistenceAdapter;
import dev.practice.money.adapter.out.persistence.jpa.MembersMoneyJpaEntity;
import dev.practice.money.adapter.out.persistence.jpa.MembersMoneyJpaRepository;
import dev.practice.money.application.port.out.FindMembersMoneyPort;
import dev.practice.money.domain.MembersMoney;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembersMoneyQueryAdapter implements FindMembersMoneyPort {

    private final MembersMoneyJpaRepository membersMoneyJpaRepository;

    @Override
    public MembersMoney get(MembersMoney.MemberId memberId) {

        return membersMoneyJpaRepository.findByMemberId(memberId.getMemberIdValue())
                .orElseThrow()
                .toDomain();
    }
}
