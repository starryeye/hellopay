package dev.practice.banking.adapter.out.api.external;

import dev.practice.banking.application.port.out.RequestExternalFirmBankingPort;
import dev.practice.banking.domain.RequestedFirmBanking;
import dev.practice.common.WebClientAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebClientAdapter
public class FirmBankingClientAdapter implements RequestExternalFirmBankingPort {
    @Override
    public Boolean request(
            RequestedFirmBanking.FromBankName fromBankName,
            RequestedFirmBanking.FromBankAccountNumber fromBankAccountNumber,
            RequestedFirmBanking.ToBankName toBankName,
            RequestedFirmBanking.ToBankAccountNumber toBankAccountNumber,
            RequestedFirmBanking.Amount amount
    ) {

        log.info("[FirmBanking request] money = {}, fromBank = {}, fromAccount = {}, toBank = {}, toAccount = {}",
                amount.getAmountValue(),
                fromBankName.getFromBankNameValue(),
                fromBankAccountNumber.getFromBankAccountNumberValue(),
                toBankName.getToBankNameValue(),
                toBankAccountNumber.getToBankAccountNumberValue()
        );

        return Boolean.TRUE;
    }
}
