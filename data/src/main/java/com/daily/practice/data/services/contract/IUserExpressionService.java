package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.UserExpression;
import com.daily.practice.data.request.PersistUserExpressionRequest;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.DataResponse2;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.response.PersistResponse2;

import java.util.List;

public interface IUserExpressionService {
    PersistResponse2<UserExpression> create(PersistUserExpressionRequest request);
    DataResponse2<List<UserExpression>> getByUserId(int userId);
}
