package dev.practice.banking.adapter.in.web.response;

import dev.practice.banking.domain.RequestedFirmBanking;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class RequestedFirmBankingListResponse {

    private final String memberId;
    private final List<RequestedFirmBankingDetailResponse> requestedFirmBankingList;

    @Builder
    private RequestedFirmBankingListResponse(String memberId, List<RequestedFirmBankingDetailResponse> requestedFirmBankingList) {
        this.memberId = memberId;
        this.requestedFirmBankingList = requestedFirmBankingList;
    }

    public static RequestedFirmBankingListResponse of(String memberId, List<RequestedFirmBanking> domains) {
        return RequestedFirmBankingListResponse.builder()
                .memberId(memberId)
                .requestedFirmBankingList(
                        domains.stream()
                                .map(RequestedFirmBankingDetailResponse::of)
                                .toList()
                )
                .build();
    }
}
