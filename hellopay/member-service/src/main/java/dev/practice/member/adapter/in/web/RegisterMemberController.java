package dev.practice.member.adapter.in.web;

import dev.practice.common.WebAdapter;
import dev.practice.member.adapter.in.web.request.RegisterMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members/")
public class RegisterMemberController {

    @PostMapping("/new")
    public void register(@RequestBody RegisterMemberRequest request) {


    }
}
