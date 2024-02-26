package com.daily.practice.data.controller;

import com.daily.practice.data.domain.Expression;
import com.daily.practice.data.response.DataResponse;
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
    @GetMapping("/{expressionId}")
    private ResponseEntity<DataResponse<Expression>> getExpressionById(@PathVariable int expressionId) {
        DataResponse<Expression> dataResponse = expressionService.getExpressionById(expressionId);
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }

    @GetMapping("/user/{userId}/new/{newFlag}")
    private ResponseEntity<?> getExpressionsByUserId(@PathVariable int userId, @PathVariable boolean newFlag) {
        DataResponse<List<Expression>> dataResponse = expressionService.getExpressionsByUserId(userId, newFlag);
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }

}
