package dev.practice.money.application.port.out;

import dev.practice.money.domain.MembersMoney;

public interface FindMembersMoneyPort {

    MembersMoney get(MembersMoney.MemberId memberId);
}
