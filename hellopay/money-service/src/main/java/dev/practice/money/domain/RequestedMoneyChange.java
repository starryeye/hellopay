package dev.practice.money.domain;

import dev.practice.money.domain.enums.MoneyChangeStatus;
import dev.practice.money.domain.enums.MoneyChangeType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestedMoneyChange {

    /**
     * 고객의 선불 충전 금액(머니) 변동(충전, 감액) 요청 정보
     */

    private final String requestedMoneyChangeId;

    private final String targetMemberId;

    private final Integer amount;
    private final MoneyChangeType type;
    private final MoneyChangeStatus status;

    private final String transactionId;
    private final LocalDateTime createdAt;

    public static RequestedMoneyChange create(
            RequestedMoneyChangeId requestedMoneyChangeId,
            TargetMemberId targetMemberId,
            Amount amount,
            Type type,
            Status status,
            TransactionId transactionId,
            CreatedAt createdAt
    ) {
        return new RequestedMoneyChange(
                requestedMoneyChangeId.getRequestedMoneyChangeIdValue(),
                targetMemberId.getTargetMemberIdValue(),
                amount.getAmountValue(),
                type.getTypeValue(),
                status.getStatusValue(),
                transactionId.getTransactionIdValue(),
                createdAt.getCreatedAtValue()
        );
    }

    @Value
    public static class RequestedMoneyChangeId {
        String requestedMoneyChangeIdValue;

        public RequestedMoneyChangeId(String value) {
            this.requestedMoneyChangeIdValue = value;
        }
    }

    @Value
    public static class TargetMemberId {
        String targetMemberIdValue;

        public TargetMemberId(String value) {
            this.targetMemberIdValue = value;
        }
    }

    @Value
    public static class Amount {
        Integer amountValue;

        public Amount(Integer value) {
            this.amountValue = value;
        }
    }

    @Value
    public static class Type {
        MoneyChangeType typeValue;
        public Type(MoneyChangeType value) {
            this.typeValue = value;
        }
    }

    @Value
    public static class Status {
        MoneyChangeStatus statusValue;
        public Status(MoneyChangeStatus value) {
            this.statusValue = value;
        }
    }

    @Value
    public static class TransactionId {
        String transactionIdValue;
        public TransactionId(String value) {
            this.transactionIdValue = value;
        }
    }

    @Value
    public static class CreatedAt {
        LocalDateTime createdAtValue;
        public CreatedAt(LocalDateTime value) {
            this.createdAtValue = value;
        }
    }
}
