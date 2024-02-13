package com.daily.practice.data.controller;

import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.services.contract.ITopicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topics")
@RequiredArgsConstructor
public class TopicController {

    private final ITopicsService topicsService;

    @GetMapping()
    public ResponseEntity<?> getTopics() {
        DataResponse dataResponse = topicsService.getTopics();
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }

    @GetMapping("types")
    public ResponseEntity<?> getTopicTypes() {
        DataResponse dataResponse = topicsService.getTopicTypes();
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }

}