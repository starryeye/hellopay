package dev.practice.banking.adapter.in.web;

import dev.practice.banking.adapter.in.web.request.RequestFirmBankingRequest;
import dev.practice.banking.adapter.in.web.response.RequestFirmBankingResponse;
import dev.practice.banking.application.port.in.RequestFirmBankingUseCase;
import dev.practice.banking.application.port.in.source.RequestFirmBankingSource;
import dev.practice.banking.domain.RequestedFirmBanking;
import dev.practice.common.WebAdapter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/banking/firm-banking")
public class RequestFirmBankingController {

    private final RequestFirmBankingUseCase requestFirmBankingUseCase;



    // 펌뱅킹 작업 요청 ( 실물 계좌 송금/입금 요청)
    // input : from/to bank account, money
    // output : requestFirmBankingUUID


    @PostMapping("/request")
    public ResponseEntity<RequestFirmBankingResponse> requestFirmBanking(
            @Valid @RequestBody RequestFirmBankingRequest request,
            @RequestHeader("X-MEMBER-ID") String memberId
    ) {

        RequestFirmBankingSource source = RequestFirmBankingSource.builder()
                .requestedMemberId(memberId)
                .fromBankName(request.getFromBankName())
                .fromBankAccountNumber(request.getFromBankAccountNumber())
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .amount(request.getAmount())
                .build();

        RequestedFirmBanking executed = requestFirmBankingUseCase.execute(source);

        return ResponseEntity.ok(RequestFirmBankingResponse.of(executed));
    }
}
