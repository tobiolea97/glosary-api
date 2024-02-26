package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.UserExpression;
import com.daily.practice.data.request.PersistUserExpressionRequest;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.PersistResponse;

import java.util.List;

public interface IUserExpressionService {
    PersistResponse<UserExpression> create(PersistUserExpressionRequest request);
    DataResponse<List<UserExpression>> getByUserId(int userId);
}
