package dev.practice.banking.adapter.out.api.external;

import dev.practice.banking.application.port.out.CheckBankAccountValidationPort;
import dev.practice.common.WebClientAdapter;
import lombok.RequiredArgsConstructor;

@WebClientAdapter
@RequiredArgsConstructor
public class BankAccountClientAdapter implements CheckBankAccountValidationPort {


    @Override
    public Boolean isValid() {
        // todo, external banking interaction
        return true;
    }
}
