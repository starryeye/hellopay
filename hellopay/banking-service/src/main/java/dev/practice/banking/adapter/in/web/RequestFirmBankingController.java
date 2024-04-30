package dev.practice.banking.adapter.in.web;

import dev.practice.banking.adapter.in.web.request.RequestFirmBankingRequest;
import dev.practice.banking.adapter.in.web.response.RequestFirmBankingResponse;
import dev.practice.banking.application.port.in.RequestFirmBankingUseCase;
import dev.practice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<RequestFirmBankingResponse> requestFirmBanking(@RequestBody RequestFirmBankingRequest request) {

    }
}
