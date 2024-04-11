package dev.practice.member.adapter.in.web;

import dev.practice.common.WebAdapter;
import dev.practice.member.adapter.in.web.response.MemberResponse;
import dev.practice.member.application.port.in.FindMemberUseCase;
import dev.practice.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class FindMemberController {

    private final FindMemberUseCase useCase;

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponse> get(@PathVariable("memberId") String memberId) {

        Member executed = useCase.execute(memberId);

        return ResponseEntity.ok(MemberResponse.of(executed));
    }
}
