package dev.practice.banking.application.port.in.source;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterBankAccountSource {

    private final String memberId;
    private final String bankName;
    private final Long bankAccountNumber;

    @Builder
    private RegisterBankAccountSource(String memberId, String bankName, Long bankAccountNumber) {
        this.memberId = memberId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
    }

    public static RegisterBankAccountSource create(String memberId, String bankName, Long bankAccountNumber) {
        return RegisterBankAccountSource.builder()
                .memberId(memberId)
                .bankName(bankName)
                .bankAccountNumber(bankAccountNumber)
                .build();
    }
}
