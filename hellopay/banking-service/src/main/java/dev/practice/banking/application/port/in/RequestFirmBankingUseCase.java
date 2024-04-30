package dev.practice.banking.application.port.in;

import dev.practice.banking.application.port.in.source.RequestFirmBankingSource;
import dev.practice.banking.domain.RequestedFirmBanking;

public interface RequestFirmBankingUseCase {

    RequestedFirmBanking requestFirmBanking(RequestFirmBankingSource requestFirmBankingSource);
}
