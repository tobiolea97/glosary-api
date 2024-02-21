package com.daily.practice.business.external.service.contract;

import com.daily.practice.business.external.service.request.CreateUserTopicRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("DP-DATA-SERVICE")
public interface IDataExternalService {
    @GetMapping("topics")
    ResponseEntity<?> getTopics();
    @GetMapping("topics/types")
    ResponseEntity<?> getTopicTypes();

    @PostMapping("/user-topic")
    ResponseEntity<?> assignTopicToUser(@RequestBody CreateUserTopicRequest request);
}
