package dev.practice.money.application.service;

import dev.practice.common.UseCase;
import dev.practice.money.application.port.in.IncreaseMoneyUseCase;
import dev.practice.money.application.port.out.FindMembersMoneyPort;
import dev.practice.money.application.port.out.RecordRequestedMoneyChangePort;
import dev.practice.money.application.port.out.UpdateMembersMoneyBalancePort;
import dev.practice.money.domain.MembersMoney;
import dev.practice.money.domain.RequestedMoneyChange;
import dev.practice.money.domain.enums.MoneyChangeStatus;
import dev.practice.money.domain.enums.MoneyChangeType;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class RequestMoneyChange implements IncreaseMoneyUseCase {

    private final RecordRequestedMoneyChangePort recordRequestedMoneyChangePort;

    private final FindMembersMoneyPort findMembersMoneyPort;
    private final UpdateMembersMoneyBalancePort updateMembersMoneyBalancePort;

    @Transactional
    @Override
    public RequestedMoneyChange increaseMoney(
            RequestedMoneyChange.TargetMemberId targetMemberId,
            RequestedMoneyChange.Amount amount
    ) {

        // 1. todo, 맴버 정보가 정상인지 확인 (member-service)

        // 2. todo, 맴버의 연동된 계좌가 있는지, 맴버의 연동된 실물 계좌의 잔액이 충분한지도 확인 (banking-service)

        // 3. todo, 법인 계좌 상태도 정상인지 확인 (banking-service)

        // 4. 증액 요청 도메인을 요청 상태로 RequestedMoneyChange 를 생성 및 저장
        RequestedMoneyChange.Type changeType = new RequestedMoneyChange.Type(MoneyChangeType.INCREASE);
        RequestedMoneyChange.Status changeStatus = new RequestedMoneyChange.Status(MoneyChangeStatus.REQUESTED);
        RequestedMoneyChange.TransactionId transactionId = new RequestedMoneyChange.TransactionId(UUID.randomUUID().toString());
        RequestedMoneyChange requestedMoneyChange = recordRequestedMoneyChangePort.record(targetMemberId, amount, changeType, changeStatus, transactionId);


        // 5. todo, 펌뱅킹을 수행하고 (맴버 실물 계좌 -> hellopay 법인 계좌) (banking-service)

        // 6-1. 결과가 정상적이라면. 성공으로 RequestedMoneyChange 상태 값을 업데이트 후에 리턴
        // 성공 시에 멤버의 MembersMoney 도메인 증액
        increaseMembersMoneyBalance(targetMemberId.getTargetMemberIdValue(), amount.getAmountValue());

        // 6-2. 결과가 실패라면, 실패라고 RequestedMoneyChange 상태 값을 업데이트 후에 리턴

        return requestedMoneyChange;
    }

    private void increaseMembersMoneyBalance(Long memberIdValue, Integer amountValue) {
        MembersMoney.MemberId memberId = new MembersMoney.MemberId(memberIdValue);
        MembersMoney money = findMembersMoneyPort.get(memberId);

        MembersMoney.MembersMoneyId membersMoneyId = new MembersMoney.MembersMoneyId(money.getMembersMoneyId());
        Integer increasedBalance  = money.getBalance() + amountValue;
        MembersMoney.Balance updatedBalance = new MembersMoney.Balance(increasedBalance);
        updateMembersMoneyBalancePort.updateBalance(membersMoneyId, updatedBalance);
    }
}
