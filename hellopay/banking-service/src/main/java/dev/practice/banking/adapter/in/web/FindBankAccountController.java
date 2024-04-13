package dev.practice.banking.adapter.in.web;

import dev.practice.banking.adapter.in.web.response.RegisteredBankAccountListResponse;
import dev.practice.banking.application.port.in.FindBankAccountUseCase;
import dev.practice.banking.domain.RegisteredBankAccount;
import dev.practice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/banking/account")
public class FindBankAccountController {

    private final FindBankAccountUseCase findBankAccountUseCase;

    @GetMapping
    public ResponseEntity<RegisteredBankAccountListResponse> get(
            @RequestParam("memberId") String memberId
    ) {
        List<RegisteredBankAccount> executed = findBankAccountUseCase.execute(memberId);

        return ResponseEntity.ok(RegisteredBankAccountListResponse.of(memberId, executed));
    }
}
