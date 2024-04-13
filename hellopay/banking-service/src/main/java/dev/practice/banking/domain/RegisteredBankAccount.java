package dev.practice.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredBankAccount {

    private final String registeredBankAccountId;
    private final String memberId; // hellopay 회원, 소유자
    private final String bankName;
    private final Long bankAccountNumber;
    private final Boolean linkedStatusIsValid; // 외부 실물 계좌 연동 유효성

    public static RegisteredBankAccount create(
            RegisteredBankAccountId registeredBankAccountId,
            MemberId memberId,
            BankName bankName,
            BankAccountNumber bankAccountNumber,
            LinkedStatusIsValid linkedStatusIsValid
    ){
        return new RegisteredBankAccount(
                registeredBankAccountId.getRegisteredBankAccountIdValue(),
                memberId.getMemberIdValue(),
                bankName.getBankNameValue(),
                bankAccountNumber.getBankAccountNumberValue(),
                linkedStatusIsValid.getLinkedStatusIsValidValue()
        );
    }

    @Value
    public static class RegisteredBankAccountId {
        String registeredBankAccountIdValue;

        public RegisteredBankAccountId(String value) {
            this.registeredBankAccountIdValue = value;
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
    public static class BankName {
        String bankNameValue;

        public BankName(String value) {
            this.bankNameValue = value;
        }
    }

    @Value
    public static class BankAccountNumber {
        Long bankAccountNumberValue;

        public BankAccountNumber(Long value) {
            this.bankAccountNumberValue = value;
        }
    }

    @Value
    public static class LinkedStatusIsValid {
        Boolean linkedStatusIsValidValue;

        public LinkedStatusIsValid(Boolean value) {
            this.linkedStatusIsValidValue = value;
        }
    }
}
