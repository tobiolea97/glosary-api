package com.daily.practice.business.controller;

import com.daily.practice.business.response.DataResponse_old;
import com.daily.practice.business.service.contract.IQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final IQuizService quizService;

    @GetMapping("/user/{userId}/topic/{topicId}")
    public ResponseEntity<?> getQuiz(@PathVariable("userId") int userId, @PathVariable("topicId") int topicId) {
        DataResponse_old response = quizService.getQuiz(userId, topicId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
