package com.daily.practice.data.controller;

import com.daily.practice.data.domain.User;
import com.daily.practice.data.domain.UserExpression;
import com.daily.practice.data.request.CreateUserTopicRequest;
import com.daily.practice.data.request.PersistUserExpressionRequest;
import com.daily.practice.data.response.DataResponse2;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.response.PersistResponse2;
import com.daily.practice.data.services.contract.IUserExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-expression")
@RequiredArgsConstructor
public class UserExpressionController {

    private final IUserExpressionService userExpressionService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<PersistResponse2<UserExpression>> create(@RequestBody PersistUserExpressionRequest request) {
        PersistResponse2<UserExpression> persistResponse = userExpressionService.create(request);
        return ResponseEntity.status(persistResponse.getStatus()).body(persistResponse);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<DataResponse2<List<UserExpression>>> getByUserId(@PathVariable int userId) {
        DataResponse2<List<UserExpression>> response = userExpressionService.getByUserId(userId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
