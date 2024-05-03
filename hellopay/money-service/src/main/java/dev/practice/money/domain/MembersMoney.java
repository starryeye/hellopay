package dev.practice.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MembersMoney {

    /**
     * 맴버 머니 잔액 정보
     * Member 와 1:1 관계
     */

    private final String membersMoneyId;

    private final String memberId;
    private final Integer balance;

    public static MembersMoney create(
            MembersMoneyId membersMoneyId,
            MemberId memberId,
            Balance balance
    ) {
        return new MembersMoney(
                membersMoneyId.getMembersMoneyIdValue(),
                memberId.getMemberIdValue(),
                balance.getBalanceValue()
        );
    }

    @Value
    public static class MembersMoneyId {
        String membersMoneyIdValue;

        public MembersMoneyId(String value) {
            this.membersMoneyIdValue = value;
        }
    }

    @Value
    public static class MemberId {
        String memberIdValue;

        public MemberId(String value) {
            this.memberIdValue = value;
        }
    }

    @Value
    public static class Balance {
        Integer balanceValue;

        public Balance(Integer value) {
            this.balanceValue = value;
        }
    }
}
