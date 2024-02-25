package com.daily.practice.business.external.service.contract;

import com.daily.practice.business.domain.*;
import com.daily.practice.business.external.service.request.CreateUserTopicRequest;
import com.daily.practice.business.external.service.request.PersistUserExpressionRequest;
import com.daily.practice.business.response.DataResponse;
import com.daily.practice.business.response.PersistResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("DP-DATA-SERVICE")
public interface IDataExternalService {
    @GetMapping("topics")
    ResponseEntity<DataResponse<List<Topic>>> getTopics();
    @GetMapping("topics/types")
    ResponseEntity<DataResponse<List<TopicType>>> getTopicTypes();
    @PostMapping("/user-topic")
    ResponseEntity<PersistResponse<UserTopic>> assignTopicToUser(@RequestBody CreateUserTopicRequest request);
    @GetMapping("/{expressionId}")
    ResponseEntity<?> getExpressionById(@PathVariable int expressionId);
    @GetMapping("expression/new/{userId}")
    ResponseEntity<DataResponse<List<Expression>>> getNewExpressions(@PathVariable int userId);
    @PostMapping("user-expression")
    ResponseEntity<PersistResponse<UserExpression>> createUserExpression(@RequestBody PersistUserExpressionRequest request);

    @GetMapping("user-expression/{userId}")
    ResponseEntity<DataResponse<List<UserExpression>>> getUserExpressionsByUserId(@PathVariable int userId);
    @GetMapping("topics/{userId}")
    ResponseEntity<DataResponse<List<Topic>>> getTopicsByUserId(@PathVariable int userId);

    @GetMapping("expression/user/{userId}")
    ResponseEntity<DataResponse<List<Expression>>> getExpressionsByUserId(@PathVariable int userId);

    @GetMapping("quiz/user/{userId}/topic/{topicId}")
    ResponseEntity<?> getQuizItemsForUserAndTopic(@PathVariable("userId") int userId, @PathVariable("topicId") int topicId);
}
