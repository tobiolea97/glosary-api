package com.daily.practice.business.controller;

import com.daily.practice.business.domain.TopicType;
import com.daily.practice.business.response.DataResponse;
import com.daily.practice.business.response.DataResponse_old;
import com.daily.practice.business.service.contract.IWelcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/welcome")
@RequiredArgsConstructor
public class WelcomeController {
    private final IWelcomeService welcomeService;
    @GetMapping
    public ResponseEntity<DataResponse<List<TopicType>>> getWelcomeScreenData(
            @RequestHeader(value = "Authorization", required = false) String authorizationHeader
    ) {
        DataResponse<List<TopicType>> response = welcomeService.getWelcomeScreenData();
        return ResponseEntity.status(response.getStatus()).body(response);
    }


}
