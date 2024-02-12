package com.daily.practice.data.repository.contract;

import com.daily.practice.data.domain.Example;

import java.util.List;

public interface IExampleRepository {
    List<Example> getExpressionExamples(int expressionId);
}
