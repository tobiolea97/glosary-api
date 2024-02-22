package com.daily.practice.business.controller;

import com.daily.practice.business.response.DataResponse;
import com.daily.practice.business.service.contract.IHomeService;
import com.daily.practice.business.service.contract.IUserExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
@RequiredArgsConstructor
public class HomeController {
    private final IHomeService homeService;
    @GetMapping("stats/{userId}")
    private ResponseEntity<?> getStats(@PathVariable int userId) {
        DataResponse dataResponse = homeService.getStats(userId);
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }

}
