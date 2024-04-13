package dev.practice.banking.adapter.out.persistence;

import dev.practice.banking.application.port.out.RegisterBankAccountPort;
import dev.practice.banking.domain.RegisteredBankAccount;
import dev.practice.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountCommandAdapter implements RegisterBankAccountPort {

    private final RegisteredBankAccountJpaRepository registeredBankAccountJpaRepository;

    @Override
    public RegisteredBankAccount register(
            RegisteredBankAccount.MemberId memberId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    ) {

        RegisteredBankAccountJpaEntity entity = RegisteredBankAccountJpaEntity.create(
                Long.parseLong(memberId.getMemberIdValue()),
                bankName.getBankNameValue(),
                bankAccountNumber.getBankAccountNumberValue(),
                linkedStatusIsValid.getLinkedStatusIsValidValue()
        );

        registeredBankAccountJpaRepository.save(entity);

        return entity.toDomain();
    }
}
