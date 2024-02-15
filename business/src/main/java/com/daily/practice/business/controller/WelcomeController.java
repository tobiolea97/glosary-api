package com.daily.practice.business.controller;

import com.daily.practice.business.service.contract.IWelcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
@RequiredArgsConstructor
public class WelcomeController {

    private final IWelcomeService welcomeService;

    @GetMapping
    public ResponseEntity<?> getWelcomeScreenData() {

        return ResponseEntity.ok(welcomeService.getWelcomeScreenData());
    }


}
