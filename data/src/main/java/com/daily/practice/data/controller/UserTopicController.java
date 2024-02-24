package com.daily.practice.data.controller;

import com.daily.practice.data.domain.UserTopic;
import com.daily.practice.data.request.CreateUserTopicRequest;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.response.PersistResponse2;
import com.daily.practice.data.services.UserTopicService;
import com.daily.practice.data.services.contract.IUserTopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-topic")
@RequiredArgsConstructor
public class UserTopicController {
    private final IUserTopicService userTopicService;
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<PersistResponse2<UserTopic>> assign(@RequestBody CreateUserTopicRequest request) {
        PersistResponse2<UserTopic> persistResponse = userTopicService.assignTopicToUser(request);
        return ResponseEntity.status(persistResponse.getStatus()).body(persistResponse);
    }


}
