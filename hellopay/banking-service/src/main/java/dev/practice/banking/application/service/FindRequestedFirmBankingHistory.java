package dev.practice.banking.application.service;

import dev.practice.banking.application.port.in.FindRequestedFirmBankingHistoryUseCase;
import dev.practice.banking.application.port.out.FindRequestedFirmBankingPort;
import dev.practice.banking.domain.RequestedFirmBanking;
import dev.practice.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindRequestedFirmBankingHistory implements FindRequestedFirmBankingHistoryUseCase {

    private final FindRequestedFirmBankingPort findRequestedFirmBankingPort;

    @Override
    public List<RequestedFirmBanking> execute(String memberId) {

        return findRequestedFirmBankingPort.get(new RequestedFirmBanking.RequestedMemberId(memberId));
    }
}
