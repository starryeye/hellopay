package dev.practice.money.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestedMoneyChangeJpaRepository extends JpaRepository<RequestedMoneyChangeJpaEntity, Long> {
}
