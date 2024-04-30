package dev.practice.banking.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestedFirmBankingJpaRepository extends JpaRepository<RequestedFirmBankingJpaEntity, Long> {
}
