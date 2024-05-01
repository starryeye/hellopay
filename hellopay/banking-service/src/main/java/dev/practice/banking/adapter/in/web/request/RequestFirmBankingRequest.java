package dev.practice.banking.adapter.in.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RequestFirmBankingRequest {

    @NotBlank
    private final String fromBankName;
    @Positive
    private final Long fromBankAccountNumber;
    @NotBlank
    private final String toBankName;
    @Positive
    private final Long toBankAccountNumber;
    @Positive
    private final Integer amount;

    @Builder
    private RequestFirmBankingRequest(String fromBankName, Long fromBankAccountNumber, String toBankName, Long toBankAccountNumber, Integer amount) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.amount = amount;
    }
}
