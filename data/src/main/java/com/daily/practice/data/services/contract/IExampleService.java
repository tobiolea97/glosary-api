package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.Example;
import com.daily.practice.data.response.DataResponse;

import java.util.List;

public interface IExampleService {
    DataResponse<List<Example>> getExpressionExamples(int expressionId);
    //DataResponse2<List<Example>> getExpressionExamples2(int expressionId);
    //DataResponse2<Example> getExpressionExamples3(int expressionId);
}
