package dev.practice.banking.application.port.in;

import dev.practice.banking.domain.RequestedFirmBanking;

import java.util.List;

public interface FindRequestedFirmBankingHistoryUseCase {

    List<RequestedFirmBanking> execute(String memberId);
}
