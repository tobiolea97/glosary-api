package com.daily.practice.data.services.contract;

import com.daily.practice.data.request.PersistUserExpressionRequest;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.PersistResponse;

public interface IUserExpressionService {
    PersistResponse create(PersistUserExpressionRequest request);
    DataResponse getByUserId(int userId);
}
