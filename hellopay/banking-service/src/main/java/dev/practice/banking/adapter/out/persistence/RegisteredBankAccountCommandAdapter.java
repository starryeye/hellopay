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
    public RegisteredBankAccount register() {
        return null;
    }
}
