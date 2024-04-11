package dev.practice.member.adapter.in.web;

import dev.practice.member.adapter.in.web.request.ChangeMemberNameRequest;
import dev.practice.member.adapter.in.web.response.MemberResponse;
import dev.practice.member.application.port.in.ChangeMemberNameUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class ChangeMemberNameController {

    private final ChangeMemberNameUseCase changeMemberNameUseCase;

    @PostMapping("/change-name")
    public ResponseEntity<MemberResponse> changeName(@Valid @RequestBody ChangeMemberNameRequest request) {

        return ResponseEntity.ok(
                MemberResponse.of(
                        changeMemberNameUseCase.execute(request.getId(), request.getName()
                        )
                )
        );
    }
}
