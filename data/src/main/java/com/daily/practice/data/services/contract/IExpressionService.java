package com.daily.practice.data.services.contract;

import com.daily.practice.data.response.DataResponse;

public interface IExpressionService {
    DataResponse getNewExpressionsForUser(int userId);
    DataResponse getExpressionById(int expressionId);
    DataResponse getExpressionsByUserId(int userId);
}
