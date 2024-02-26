package com.daily.practice.data.controller;

import com.daily.practice.data.domain.UserTopic;
import com.daily.practice.data.request.CreateUserTopicRequest;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.services.contract.IUserTopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PersistResponse<UserTopic>> assign(@RequestBody CreateUserTopicRequest request) {
        PersistResponse<UserTopic> persistResponse = userTopicService.assignTopicToUser(request);
        return ResponseEntity.status(persistResponse.getStatus()).body(persistResponse);
    }

}
