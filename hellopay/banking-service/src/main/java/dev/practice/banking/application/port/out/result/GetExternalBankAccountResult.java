package dev.practice.banking.application.port.out.result;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetExternalBankAccountResult {

    // todo, domain 으로 격상 고려?

    private final String bankName;
    private final Long bankAccountNumber;
    private final Boolean isValid; // 외부 실물 계좌 유효성
    private final LocalDateTime openAt; // 개설일

    @Builder
    private GetExternalBankAccountResult(String bankName, Long bankAccountNumber, Boolean isValid, LocalDateTime openAt) {
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.isValid = isValid;
        this.openAt = openAt;
    }
}
