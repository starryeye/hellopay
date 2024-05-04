package dev.practice.money.application.port.out;

import dev.practice.money.domain.MembersMoney;

public interface UpdateMembersMoneyBalancePort {

    void updateBalance(MembersMoney.MembersMoneyId membersMoneyId, MembersMoney.Balance updatedBalance);
}
