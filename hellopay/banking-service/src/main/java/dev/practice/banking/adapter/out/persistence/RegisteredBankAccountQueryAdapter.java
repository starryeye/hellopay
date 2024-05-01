package dev.practice.banking.adapter.out.persistence;

import dev.practice.banking.adapter.out.persistence.jpa.RegisteredBankAccountJpaEntity;
import dev.practice.banking.adapter.out.persistence.jpa.RegisteredBankAccountJpaRepository;
import dev.practice.banking.application.port.out.FindRegisteredBankAccountPort;
import dev.practice.banking.domain.RegisteredBankAccount;
import dev.practice.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountQueryAdapter implements FindRegisteredBankAccountPort {

    private final RegisteredBankAccountJpaRepository registeredBankAccountJpaRepository;

    @Transactional(readOnly = true) // todo, service 에 걸어야할까?
    @Override
    public List<RegisteredBankAccount> get(RegisteredBankAccount.MemberId memberId) {

        List<RegisteredBankAccountJpaEntity> result = registeredBankAccountJpaRepository.findByMemberId(Long.parseLong(memberId.getMemberIdValue()));

        return result.stream()
                .map(RegisteredBankAccountJpaEntity::toDomain)
                .toList();
    }
}
