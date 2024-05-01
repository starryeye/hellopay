package dev.practice.banking.application.port.out;

import dev.practice.banking.domain.RequestedFirmBanking;

public interface UpdateRequestedFirmBankingPort {

    RequestedFirmBanking changeStatus(
            RequestedFirmBanking.RequestedFirmBankingId requestedFirmBankingId,
            RequestedFirmBanking.RequestStatus requestStatus
    );
}
