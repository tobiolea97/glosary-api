package com.daily.practice.data.controller;

import com.daily.practice.data.domain.Expression;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.DataResponse2;
import com.daily.practice.data.services.contract.IExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expression")
@RequiredArgsConstructor
public class ExpressionController {
    private final IExpressionService expressionService;
    @GetMapping("/new/{userId}")
    private ResponseEntity<DataResponse2<List<Expression>>> getNewExpressions(@PathVariable int userId) {
        DataResponse2<List<Expression>> dataResponse = expressionService.getNewExpressionsForUser(userId);
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }

    @GetMapping("/{expressionId}")
    private ResponseEntity<DataResponse2<Expression>> getExpressionById(@PathVariable int expressionId) {
        DataResponse2<Expression> dataResponse = expressionService.getExpressionById(expressionId);
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }

    @GetMapping("/user/{userId}")
    private ResponseEntity<?> getExpressionsByUserId(@PathVariable int userId) {
        DataResponse2<List<Expression>> dataResponse = expressionService.getExpressionsByUserId(userId);
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }

}
