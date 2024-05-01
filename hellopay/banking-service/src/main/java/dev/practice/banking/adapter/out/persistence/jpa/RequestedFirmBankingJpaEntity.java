package dev.practice.banking.adapter.out.persistence.jpa;

import dev.practice.banking.domain.RequestedFirmBanking;
import dev.practice.banking.domain.enums.RequestedFirmBankingType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestedFirmBankingJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromBankName;
    private Long fromBankAccountNumber;
    private String toBankName;
    private Long toBankAccountNumber;
    private Integer amount;

    @Enumerated(EnumType.STRING)
    private RequestedFirmBankingType status;
    private String transactionId;

    @Builder
    private RequestedFirmBankingJpaEntity(Long id, String fromBankName, Long fromBankAccountNumber, String toBankName, Long toBankAccountNumber, Integer amount, RequestedFirmBankingType status, String transactionId) {
        this.id = id;
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.amount = amount;
        this.status = status;
        this.transactionId = transactionId;
    }

    public static RequestedFirmBankingJpaEntity create(String fromBankName, Long fromBankAccountNumber, String toBankName, Long toBankAccountNumber, Integer amount, RequestedFirmBankingType status, String transactionId) {
        return RequestedFirmBankingJpaEntity.builder()
                .id(null)
                .fromBankName(fromBankName)
                .fromBankAccountNumber(fromBankAccountNumber)
                .toBankName(toBankName)
                .toBankAccountNumber(toBankAccountNumber)
                .amount(amount)
                .status(status)
                .transactionId(transactionId)
                .build();
    }

    public RequestedFirmBanking toDomain() {
        return RequestedFirmBanking.create(
                new RequestedFirmBanking.RequestedFirmBankingId(id),
                new RequestedFirmBanking.FromBankName(fromBankName),
                new RequestedFirmBanking.FromBankAccountNumber(fromBankAccountNumber),
                new RequestedFirmBanking.ToBankName(toBankName),
                new RequestedFirmBanking.ToBankAccountNumber(toBankAccountNumber),
                new RequestedFirmBanking.Amount(amount),
                new RequestedFirmBanking.RequestStatus(status),
                new RequestedFirmBanking.TransactionId(transactionId)
        );
    }

    public void changeStatus(RequestedFirmBankingType newStatus) {
        this.status = newStatus;
    }
}
