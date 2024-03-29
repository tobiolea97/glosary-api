package com.daily.practice.business.controller;

import com.daily.practice.business.domain.UserExpression;
import com.daily.practice.business.external.service.request.PersistUserExpressionRequest;
import com.daily.practice.business.response.PersistResponse;
import com.daily.practice.business.response.PersistResponse_old;
import com.daily.practice.business.service.contract.IUserExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-expression")
@RequiredArgsConstructor
public class UserExpressionController {
    private final IUserExpressionService userExpressionService;
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<PersistResponse<UserExpression>> create(@RequestBody PersistUserExpressionRequest request) {
        PersistResponse<UserExpression> persistResponse = userExpressionService.create(request);
        return ResponseEntity.status(persistResponse.getStatus()).body(persistResponse);
    }
}
