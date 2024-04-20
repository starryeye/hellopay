package dev.practice.banking.adapter.out.api.external.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetExternalBankAccountRequest {

    private final String bankName;
    private final Long bankAccountNumber;

    @Builder
    private GetExternalBankAccountRequest(String bankName, Long bankAccountNumber) {
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
    }
}
