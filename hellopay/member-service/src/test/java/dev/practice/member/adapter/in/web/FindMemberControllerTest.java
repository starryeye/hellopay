package dev.practice.member.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.practice.member.adapter.in.web.response.MemberResponse;
import dev.practice.member.application.port.in.FindMemberUseCase;
import dev.practice.member.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FindMemberController.class)
class FindMemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindMemberUseCase findMemberUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("회원 아이디로 회원 정보를 조회한다.")
    @Test
    void findById() throws Exception {

        // given
        String memberId = "1";
        MemberResponse expectedResponse = MemberResponse.builder()
                .memberId(memberId)
                .memberName("name")
                .memberEmail("email@practice.dev")
                .memberAddress("address")
                .memberIsValid("true")
                .memberIsCorp("false")
                .build();

        // stubbing
        Member expectFoundDomain = Member.create(
                new Member.MemberId("1"),
                new Member.MemberName("name"),
                new Member.MemberEmail("email@practice.dev"),
                new Member.MemberAddress("address"),
                new Member.MemberIsValid(true),
                new Member.MemberIsCorp(false)
        );
        when(findMemberUseCase.execute(eq(memberId)))
                .thenReturn(expectFoundDomain);


        // when
        // then
        mockMvc.perform(get("/api/v1/members/{memberId}", memberId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(expectedResponse)));
    }

}