package dev.practice.banking.application.port.out;

import dev.practice.banking.domain.RequestedFirmBanking;

public interface RegisterRequestedFirmBankingPort {

    RequestedFirmBanking register(
            RequestedFirmBanking.FromBankName fromBankName,
            RequestedFirmBanking.FromBankAccountNumber fromBankAccountNumber,
            RequestedFirmBanking.ToBankName toBankName,
            RequestedFirmBanking.ToBankAccountNumber toBankAccountNumber,
            RequestedFirmBanking.Amount amount,
            RequestedFirmBanking.RequestStatus requestStatus,
            RequestedFirmBanking.TransactionId transactionId
    );
}
