package dev.practice.money.domain;

import dev.practice.money.domain.enums.MoneyChangingStatus;
import dev.practice.money.domain.enums.MoneyChangingType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestedMoneyChanging {

    /**
     * 고객의 선불 충전 금액(머니) 변동(충전, 감액) 요청 정보
     */

    private final String requestedMoneyChangingId;

    private final String targetMemberId;

    private final Integer amount;
    private final MoneyChangingType type;
    private final MoneyChangingStatus status;

    private final String transactionId;
    private final LocalDateTime createdAt;

    public static RequestedMoneyChanging create(
            RequestedMoneyChangingId requestedMoneyChangingId,
            TargetMemberId targetMemberId,
            Amount amount,
            Type type,
            Status status,
            TransactionId transactionId,
            CreatedAt createdAt
    ) {
        return new RequestedMoneyChanging(
                requestedMoneyChangingId.getRequestedMoneyChangingIdValue(),
                targetMemberId.getTargetMemberIdValue(),
                amount.getAmountValue(),
                type.getTypeValue(),
                status.getStatusValue(),
                transactionId.getTransactionIdValue(),
                createdAt.getCreatedAtValue()
        );
    }

    @Value
    public static class RequestedMoneyChangingId {
        String requestedMoneyChangingIdValue;

        public RequestedMoneyChangingId(String value) {
            this.requestedMoneyChangingIdValue = value;
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
        MoneyChangingType typeValue;
        public Type(MoneyChangingType value) {
            this.typeValue = value;
        }
    }

    @Value
    public static class Status {
        MoneyChangingStatus statusValue;
        public Status(MoneyChangingStatus value) {
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
