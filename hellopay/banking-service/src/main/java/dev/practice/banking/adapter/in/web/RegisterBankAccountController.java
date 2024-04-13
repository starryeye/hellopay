package dev.practice.banking.adapter.in.web;

import dev.practice.banking.adapter.in.web.request.RegisterBankAccountRequest;
import dev.practice.banking.adapter.in.web.response.RegisteredBankAccountResponse;
import dev.practice.banking.application.port.in.RegisterBankAccountUseCase;
import dev.practice.banking.application.port.in.source.RegisterBankAccountSource;
import dev.practice.banking.domain.RegisteredBankAccount;
import dev.practice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/banking")
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping("/register")
    public ResponseEntity<RegisteredBankAccountResponse> register(RegisterBankAccountRequest request) {

        RegisterBankAccountSource source = RegisterBankAccountSource.create(
                request.getMemberId(),
                request.getBankName(),
                request.getBankAccountNumber()
        );

        RegisteredBankAccount executed = registerBankAccountUseCase.execute(source);

        return ResponseEntity.ok(RegisteredBankAccountResponse.of(executed));
    }
}
