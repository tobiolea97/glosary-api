package com.daily.practice.business.external.service.contract;

import com.daily.practice.business.external.service.request.CreateUserTopicRequest;
import com.daily.practice.business.external.service.request.PersistUserExpressionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/{expressionId}")
    ResponseEntity<?> getExpressionById(@PathVariable int expressionId);
    @GetMapping("expression/new/{userId}")
    ResponseEntity<?> getNewExpressions(@PathVariable int userId);
    @PostMapping("user-expression")
    ResponseEntity<?> createUserExpression(@RequestBody PersistUserExpressionRequest request);

    @GetMapping("user-expression/{userId}")
    ResponseEntity<?> getUserExpressionsByUserId(@PathVariable int userId);
    @GetMapping("topics/{userId}")
    ResponseEntity<?> getTopicsByUserId(@PathVariable int userId);

    @GetMapping("expression/user/{userId}")
    ResponseEntity<?> getExpressionsByUserId(@PathVariable int userId);

    @GetMapping("quiz/user/{userId}/topic/{topicId}")
    ResponseEntity<?> getQuizItemsForUserAndTopic(@PathVariable("userId") int userId, @PathVariable("topicId") int topicId);
}
