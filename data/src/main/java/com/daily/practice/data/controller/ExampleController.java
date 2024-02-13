package com.daily.practice.data.controller;

import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.services.contract.IExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {
    private final IExampleService exampleService;
    @GetMapping("/expression/{expressionId}")
    public ResponseEntity<?> getExample(@PathVariable int expressionId) {
        DataResponse response = exampleService.getExpressionExamples(expressionId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}