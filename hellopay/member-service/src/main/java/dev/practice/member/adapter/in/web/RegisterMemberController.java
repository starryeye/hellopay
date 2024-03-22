package dev.practice.member.adapter.in.web;

import dev.practice.common.WebAdapter;
import dev.practice.member.adapter.in.web.request.RegisterMemberRequest;
import dev.practice.member.adapter.in.web.response.RegisterMemberResponse;
import dev.practice.member.application.port.in.RegisterMemberUseCase;
import dev.practice.member.application.port.in.source.RegisterMemberSource;
import dev.practice.member.domain.Member;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class RegisterMemberController {

    private final RegisterMemberUseCase useCase;

    @PostMapping("/new")
    public ResponseEntity<RegisterMemberResponse> register(@Valid @RequestBody RegisterMemberRequest request) {

        RegisterMemberSource source = RegisterMemberSource.create(
                request.getName(),
                request.getEmail(),
                request.getAddress()
        );

        Member executed = useCase.execute(source);

        return ResponseEntity.ok(RegisterMemberResponse.of(executed));
    }
}
