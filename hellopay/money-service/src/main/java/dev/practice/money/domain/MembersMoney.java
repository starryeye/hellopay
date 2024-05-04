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

    private final Long membersMoneyId;

    private final Long memberId;
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
        Long membersMoneyIdValue;

        public MembersMoneyId(Long value) {
            this.membersMoneyIdValue = value;
        }
    }

    @Value
    public static class MemberId {
        Long memberIdValue;

        public MemberId(Long value) {
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
