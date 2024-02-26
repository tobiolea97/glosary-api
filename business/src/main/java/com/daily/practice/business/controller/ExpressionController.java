package com.daily.practice.business.controller;

import com.daily.practice.business.domain.Expression;
import com.daily.practice.business.response.DataResponse;
import com.daily.practice.business.response.DataResponse_old;
import com.daily.practice.business.service.contract.IUserExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expression")
@RequiredArgsConstructor
public class ExpressionController {
    private final IUserExpressionService expressionService;

    @GetMapping("/new/{userId}")
    private ResponseEntity<DataResponse<List<Expression>>> getNewExpressions(@PathVariable int userId) {
        DataResponse<List<Expression>> dataResponse = expressionService.getNewExpressionsForUser(userId);
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }

}
