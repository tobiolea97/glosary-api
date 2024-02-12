package com.daily.practice.data.controller;

import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.services.contract.IExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expression")
@RequiredArgsConstructor
public class ExpressionController {
    private final IExpressionService expressionService;
    @GetMapping("/new/{userId}")
    private ResponseEntity<?> getNewExpressions(@PathVariable int userId) {
        DataResponse dataResponse = expressionService.getNewExpressionsForUser(userId);
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }

    @GetMapping("/{expressionId}")
    private ResponseEntity<?> getExpressionById(@PathVariable int expressionId) {
        DataResponse dataResponse = expressionService.getExpressionById(expressionId);
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }

}
