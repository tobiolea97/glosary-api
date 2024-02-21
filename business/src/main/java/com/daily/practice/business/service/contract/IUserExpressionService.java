package com.daily.practice.business.service.contract;

import com.daily.practice.business.external.service.request.PersistUserExpressionRequest;
import com.daily.practice.business.response.DataResponse;
import com.daily.practice.business.response.PersistResponse;

public interface IUserExpressionService {
    DataResponse getNewExpressionsForUser(int userId);
    PersistResponse create(PersistUserExpressionRequest request);
}
