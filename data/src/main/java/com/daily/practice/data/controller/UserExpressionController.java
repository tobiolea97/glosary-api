package com.daily.practice.data.controller;

import com.daily.practice.data.request.CreateUserTopicRequest;
import com.daily.practice.data.request.PersistUserExpressionRequest;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.services.contract.IUserExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user-expression")
@RequiredArgsConstructor
public class UserExpressionController {

    private final IUserExpressionService userExpressionService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> create(@RequestBody PersistUserExpressionRequest request) {
        PersistResponse persistResponse = userExpressionService.create(request);
        return ResponseEntity.status(persistResponse.getStatus()).body(persistResponse);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable int userId) {
        return ResponseEntity
                .status(userExpressionService.getByUserId(userId).getStatus())
                .body(userExpressionService.getByUserId(userId));
    }

}
