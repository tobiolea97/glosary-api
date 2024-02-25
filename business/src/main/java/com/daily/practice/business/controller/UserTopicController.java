package com.daily.practice.business.controller;

import com.daily.practice.business.domain.UserTopic;
import com.daily.practice.business.external.service.request.CreateUserTopicRequest;
import com.daily.practice.business.response.PersistResponse;
import com.daily.practice.business.response.PersistResponse_old;
import com.daily.practice.business.service.contract.IUserTopicService;
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
        PersistResponse<UserTopic> persistResponse = userTopicService.assignTopicToUser(request.getUserId(), request.getTopicId());
        return ResponseEntity.status(persistResponse.getStatus()).body(persistResponse);
    }
}
