package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.Expression;
import com.daily.practice.data.response.DataResponse;

import java.util.List;

public interface IExpressionService {
    DataResponse<Expression> getExpressionById(int expressionId);
    DataResponse<List<Expression>> getExpressionsByUserId(int userId, boolean onlyNew);
}
