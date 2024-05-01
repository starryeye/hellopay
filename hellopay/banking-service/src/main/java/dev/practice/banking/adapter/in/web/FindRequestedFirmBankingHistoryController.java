package dev.practice.banking.adapter.in.web;

import dev.practice.banking.adapter.in.web.response.RequestedFirmBankingListResponse;
import dev.practice.banking.application.port.in.FindRequestedFirmBankingHistoryUseCase;
import dev.practice.banking.domain.RequestedFirmBanking;
import dev.practice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/banking/firm-banking")
public class FindRequestedFirmBankingHistoryController {

    private final FindRequestedFirmBankingHistoryUseCase findRequestedFirmBankingHistoryUseCase;
    // 펌 뱅킹 작업 내역 get
    // input : memberId
    // output : FirmBanking list

    // todo, paging.. status..
    @GetMapping
    public ResponseEntity<RequestedFirmBankingListResponse> getRequestedFirmBankingHistory(
            @RequestHeader("X-MEMBER-ID") String memberId
    ) {
        List<RequestedFirmBanking> executed = findRequestedFirmBankingHistoryUseCase.execute(memberId);

        return ResponseEntity.ok(RequestedFirmBankingListResponse.of(memberId, executed));
    }
}
