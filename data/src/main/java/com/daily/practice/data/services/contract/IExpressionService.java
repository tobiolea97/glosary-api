package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.Example;
import com.daily.practice.data.domain.Expression;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.DataResponse2;

import java.util.List;

public interface IExpressionService {
    DataResponse2<List<Expression>> getNewExpressionsForUser(int userId);
    DataResponse2<Expression> getExpressionById(int expressionId);
    DataResponse2<List<Expression>> getExpressionsByUserId(int userId);
}
