package dev.practice.banking.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestedFirmBankingJpaRepository extends JpaRepository<RequestedFirmBankingJpaEntity, Long> {

    // todo, sorting
    List<RequestedFirmBankingJpaEntity> findByRequestedMemberId(Long requestedMemberId);
}
