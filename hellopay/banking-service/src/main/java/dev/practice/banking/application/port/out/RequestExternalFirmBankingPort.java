package dev.practice.banking.application.port.out;

import dev.practice.banking.domain.RequestedFirmBanking;

public interface RequestExternalFirmBankingPort {

    Boolean request(
            RequestedFirmBanking.FromBankName fromBankName,
            RequestedFirmBanking.FromBankAccountNumber fromBankAccountNumber,
            RequestedFirmBanking.ToBankName toBankName,
            RequestedFirmBanking.ToBankAccountNumber toBankAccountNumber,
            RequestedFirmBanking.Amount amount
    );
}
