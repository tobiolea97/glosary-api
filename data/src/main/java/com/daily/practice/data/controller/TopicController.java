package com.daily.practice.data.controller;

import com.daily.practice.data.domain.Topic;
import com.daily.practice.data.domain.TopicType;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.services.contract.ITopicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topics")
@RequiredArgsConstructor
public class TopicController {

    private final ITopicsService topicsService;

    @GetMapping()
    public ResponseEntity<DataResponse<List<Topic>>> getTopics() {
        DataResponse<List<Topic>> dataResponse = topicsService.getTopics();
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }

    @GetMapping("types")
    public ResponseEntity<DataResponse<List<TopicType>>> getTopicTypes() {
        DataResponse<List<TopicType>> dataResponse = topicsService.getTopicTypes();
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }


    @GetMapping("{userId}")
    public ResponseEntity<DataResponse<List<Topic>>> getTopicsByUserId(@PathVariable int userId) {
        DataResponse<List<Topic>> dataResponse = topicsService.getTopicsByUserId(userId);
        return ResponseEntity.status(dataResponse.getStatus()).body(dataResponse);
    }
}
