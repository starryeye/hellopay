package dev.practice.money.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembersMoneyJpaRepository extends JpaRepository<MembersMoneyJpaEntity, Long> {

    Optional<MembersMoneyJpaEntity> findByMemberId(Long memberId);
}
