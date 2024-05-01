package dev.practice.banking.domain;

import dev.practice.banking.domain.enums.RequestedFirmBankingType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestedFirmBanking {

    private final Long requestedFirmBankingId;
    private final String fromBankName;
    private final Long fromBankAccountNumber;
    private final String toBankName;
    private final Long toBankAccountNumber;
    private final Integer amount;

    private final RequestedFirmBankingType requestStatus;

    private final String transactionId;


    public static RequestedFirmBanking create(
            RequestedFirmBankingId requestedFirmBankingId,
            FromBankName fromBankName,
            FromBankAccountNumber fromBankAccountNumber,
            ToBankName toBankName,
            ToBankAccountNumber toBankAccountNumber,
            Amount amount,
            RequestStatus requestStatus,
            TransactionId transactionId
    ) {
        return new RequestedFirmBanking(
                requestedFirmBankingId.getRequestedFirmBankingIdValue(),
                fromBankName.getFromBankNameValue(),
                fromBankAccountNumber.getFromBankAccountNumberValue(),
                toBankName.getToBankNameValue(),
                toBankAccountNumber.getToBankAccountNumberValue(),
                amount.getAmountValue(),
                requestStatus.getRequestStatusValue(),
                transactionId.getTransactionIdValue()
        );
    }

    @Value
    public static class RequestedFirmBankingId {
        Long requestedFirmBankingIdValue;

        public RequestedFirmBankingId(Long value) {
            this.requestedFirmBankingIdValue = value;
        }
    }

    @Value
    public static class FromBankName {
        String fromBankNameValue;

        public FromBankName(String value) {
            this.fromBankNameValue = value;
        }
    }

    @Value
    public static class FromBankAccountNumber {
        Long fromBankAccountNumberValue;

        public FromBankAccountNumber(Long value) {
            this.fromBankAccountNumberValue = value;
        }
    }

    @Value
    public static class ToBankName {
        String toBankNameValue;

        public ToBankName(String value) {
            this.toBankNameValue = value;
        }
    }

    @Value
    public static class ToBankAccountNumber {
        Long toBankAccountNumberValue;

        public ToBankAccountNumber(Long value) {
            this.toBankAccountNumberValue = value;
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
    public static class RequestStatus {
        RequestedFirmBankingType requestStatusValue;

        public RequestStatus(RequestedFirmBankingType value) {
            this.requestStatusValue = value;
        }
    }

    @Value
    public static class TransactionId {
        String transactionIdValue;

        public TransactionId(String value) {
            this.transactionIdValue = value;
        }
    }

}
