package com.daily.practice.data.controller;

import com.daily.practice.data.domain.User;
import com.daily.practice.data.request.PersistUserRequest;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.response.PersistResponse2;
import com.daily.practice.data.services.contract.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    @PatchMapping(consumes = "application/json", produces = "application/json")
    public PersistResponse2<User> update(@RequestBody PersistUserRequest request) {
        // TODO: updating a nonexisting record does not retrieve error
        PersistResponse2<User> persistResponse = userService.update(request);
        return persistResponse;
    }
}
