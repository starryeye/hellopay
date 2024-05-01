package dev.practice.banking.adapter.in.web.response;

import dev.practice.banking.domain.RequestedFirmBanking;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RequestFirmBankingResponse {

    private final String requestedMemberId;
    private final String fromBankName;
    private final Long fromBankAccountNumber;
    private final String toBankName;
    private final Long toBankAccountNumber;
    private final Integer amount;
    private final String status;
    private final String transactionId;

    @Builder
    private RequestFirmBankingResponse(String requestedMemberId, String fromBankName, Long fromBankAccountNumber, String toBankName, Long toBankAccountNumber, Integer amount, String status, String transactionId) {
        this.requestedMemberId = requestedMemberId;
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.amount = amount;
        this.status = status;
        this.transactionId = transactionId;
    }

    public static RequestFirmBankingResponse of(RequestedFirmBanking domain) {
        return RequestFirmBankingResponse.builder()
                .requestedMemberId(domain.getRequestedMemberId())
                .fromBankName(domain.getFromBankName())
                .fromBankAccountNumber(domain.getFromBankAccountNumber())
                .toBankName(domain.getToBankName())
                .toBankAccountNumber(domain.getToBankAccountNumber())
                .amount(domain.getAmount())
                .status(domain.getRequestStatus().toString())
                .transactionId(domain.getTransactionId())
                .build();
    }
}
