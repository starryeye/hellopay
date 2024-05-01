package dev.practice.banking.application.port.in.source;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RequestFirmBankingSource {

    private final String fromBankName;
    private final Long fromBankAccountNumber;
    private final String toBankName;
    private final Long toBankAccountNumber;
    private final Integer amount;

    @Builder
    private RequestFirmBankingSource(String fromBankName, Long fromBankAccountNumber, String toBankName, Long toBankAccountNumber, Integer amount) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.amount = amount;
    }
}
