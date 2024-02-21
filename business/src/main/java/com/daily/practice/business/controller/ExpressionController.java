package com.daily.practice.business.controller;

import com.daily.practice.business.response.DataResponse;
import com.daily.practice.business.service.contract.IUserExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expression")
@RequiredArgsConstructor
public class ExpressionController {
    private final IUserExpressionService expressionService;

    @GetMapping("/new/{userId}")
    private ResponseEntity<?> getNewExpressions(@PathVariable int userId) {
        DataResponse dataResponse = expressionService.getNewExpressionsForUser(userId);
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }

}
