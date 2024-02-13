package com.daily.practice.business;

import com.daily.practice.business.feign.ExampleInterface;
import com.daily.practice.business.feign.IExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    private final IExampleService exampleInterface;

    @GetMapping("/expression/{expressionId}")
    public Object getExample(@PathVariable int expressionId) {
        return exampleInterface.getExample(expressionId);
    }

}
