package com.daily.practice.business.feign;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleService implements IExampleService {

    @Autowired
    ExampleInterface exampleInterface;

    public Object getExample(int expressionId) {
        try {
            return exampleInterface.getExample(expressionId);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
