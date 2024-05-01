package dev.practice.banking.adapter.out.persistence;

import dev.practice.banking.adapter.out.persistence.jpa.RequestedFirmBankingJpaEntity;
import dev.practice.banking.adapter.out.persistence.jpa.RequestedFirmBankingJpaRepository;
import dev.practice.banking.application.port.out.FindRequestedFirmBankingPort;
import dev.practice.banking.domain.RequestedFirmBanking;
import dev.practice.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class RequestedFirmBankingQueryAdapter implements FindRequestedFirmBankingPort {

    private final RequestedFirmBankingJpaRepository requestedFirmBankingJpaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<RequestedFirmBanking> get(RequestedFirmBanking.RequestedMemberId requestedMemberId) {

        List<RequestedFirmBankingJpaEntity> entities = requestedFirmBankingJpaRepository.findByRequestedMemberId(
                Long.parseLong(requestedMemberId.getRequestedMemberIdValue())
        );

        return entities.stream()
                .map(RequestedFirmBankingJpaEntity::toDomain)
                .toList();
    }
}
