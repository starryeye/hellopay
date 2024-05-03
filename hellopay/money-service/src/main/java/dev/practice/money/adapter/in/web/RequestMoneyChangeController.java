package dev.practice.money.adapter.in.web;

import dev.practice.common.WebAdapter;
import dev.practice.money.adapter.in.web.request.IncreaseMoneyRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api/v1/money")
@RequiredArgsConstructor
public class RequestMoneyChangeController {

    // 증액 요청
    @PostMapping("/increase")
    public void increaseMoney(@Valid @RequestBody IncreaseMoneyRequest request) {

    }
}
