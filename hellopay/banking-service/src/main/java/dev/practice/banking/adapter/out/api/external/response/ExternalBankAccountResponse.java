package dev.practice.banking.adapter.out.api.external.response;

import dev.practice.banking.application.port.out.result.GetExternalBankAccountResult;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExternalBankAccountResponse {

    private final String bankName;
    private final Long bankAccountNumber;
    private final Boolean isValid;
    private final LocalDateTime openAt;

    @Builder
    private ExternalBankAccountResponse(String bankName, Long bankAccountNumber, Boolean isValid, LocalDateTime openAt) {
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.isValid = isValid;
        this.openAt = openAt;
    }

    public GetExternalBankAccountResult toDomain() {
        return GetExternalBankAccountResult.builder()
                .bankName(bankName)
                .bankAccountNumber(bankAccountNumber)
                .isValid(isValid)
                .openAt(openAt)
                .build();
    }
}
