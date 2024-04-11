package dev.practice.member.adapter.in.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ChangeMemberNameRequest {

    @NotBlank
    private final String id;

    @Size(min = 2, max = 8)
    private final String name;

    @Builder
    private ChangeMemberNameRequest(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
