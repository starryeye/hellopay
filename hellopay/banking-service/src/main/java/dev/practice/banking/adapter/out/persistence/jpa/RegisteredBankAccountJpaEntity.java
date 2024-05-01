package dev.practice.banking.adapter.out.persistence.jpa;

import dev.practice.banking.domain.RegisteredBankAccount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisteredBankAccountJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId; // hellopay 회원, 소유자

    private String bankName;
    private Long bankAccountNumber;

    private Boolean linkedStatusIsValid; // 외부 실물 계좌 연동 유효성

    @Builder
    private RegisteredBankAccountJpaEntity(Long id, Long memberId, String bankName, Long bankAccountNumber, Boolean linkedStatusIsValid) {
        this.id = id;
        this.memberId = memberId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
    }

    public static RegisteredBankAccountJpaEntity create(Long memberId, String bankName, Long bankAccountNumber, Boolean linkedStatusIsValid) {
        return RegisteredBankAccountJpaEntity.builder()
                .id(null)
                .memberId(memberId)
                .bankName(bankName)
                .bankAccountNumber(bankAccountNumber)
                .linkedStatusIsValid(linkedStatusIsValid)
                .build();
    }

    public RegisteredBankAccount toDomain() {
        return RegisteredBankAccount.create(
                new RegisteredBankAccount.RegisteredBankAccountId(String.valueOf(id)),
                new RegisteredBankAccount.MemberId(String.valueOf(memberId)),
                new RegisteredBankAccount.BankName(bankName),
                new RegisteredBankAccount.BankAccountNumber(bankAccountNumber),
                new RegisteredBankAccount.LinkedStatusIsValid(linkedStatusIsValid)
        );
    }
}
