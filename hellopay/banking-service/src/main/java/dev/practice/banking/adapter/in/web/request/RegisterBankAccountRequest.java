package dev.practice.banking.adapter.in.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterBankAccountRequest {

    @NotBlank
    private final String memberId;
    @NotBlank
    private final String bankName;
    @Positive
    private final Long bankAccountNumber;

    @Builder
    private RegisterBankAccountRequest(String memberId, String bankName, Long bankAccountNumber) {
        this.memberId = memberId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
    }
}
