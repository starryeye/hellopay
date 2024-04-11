package dev.practice.member.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.practice.member.adapter.in.web.request.RegisterMemberRequest;
import dev.practice.member.adapter.in.web.response.MemberResponse;
import dev.practice.member.application.port.in.RegisterMemberUseCase;
import dev.practice.member.application.port.in.source.RegisterMemberSource;
import dev.practice.member.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RegisterMemberController.class)
class RegisterMemberControllerTest {

    @MockBean
    private RegisterMemberUseCase registerMemberUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("회원을 등록한다.")
    @Test
    void register() throws Exception {

        // given
        RegisterMemberRequest request = RegisterMemberRequest.builder()
                .name("name")
                .email("email@practice.dev")
                .address("address")
                .build();
        MemberResponse expectedResponse = MemberResponse.builder()
                .memberId("1")
                .memberName("name")
                .memberEmail("email@practice.dev")
                .memberAddress("address")
                .memberIsValid("true")
                .memberIsCorp("false")
                .build();

        // stubbing
        // controller 에서 response 객체를 만들어 주기 때문에 stubbing 이 필요했음..
        RegisterMemberSource dto = RegisterMemberSource.builder()
                .name("name")
                .email("email@practice.dev")
                .address("address")
                .isValid(true)
                .isCorp(false)
                .build();
        Member registered = Member.create(
                new Member.MemberId("1"),
                new Member.MemberName("name"),
                new Member.MemberEmail("email@practice.dev"),
                new Member.MemberAddress("address"),
                new Member.MemberIsValid(true),
                new Member.MemberIsCorp(false)
        );
        Mockito.when(registerMemberUseCase.execute(Mockito.eq(dto)))
                        .thenReturn(registered);

        // when
        // then
        mockMvc.perform(
                        post("/api/v1/members/new")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(expectedResponse)));
    }
}