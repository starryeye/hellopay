package dev.practice.banking.application.port.out;

import dev.practice.banking.domain.RequestedFirmBanking;

import java.util.List;

public interface FindRequestedFirmBankingPort {

    List<RequestedFirmBanking> get(
            RequestedFirmBanking.RequestedMemberId requestedMemberId
    );
}
