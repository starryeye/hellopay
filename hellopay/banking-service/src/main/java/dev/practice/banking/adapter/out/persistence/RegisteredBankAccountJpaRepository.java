package dev.practice.banking.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisteredBankAccountJpaRepository extends JpaRepository<RegisteredBankAccountJpaEntity, Long> {

    List<RegisteredBankAccountJpaEntity> findByMemberId(Long memberId);
}
