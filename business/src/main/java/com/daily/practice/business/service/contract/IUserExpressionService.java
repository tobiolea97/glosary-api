package com.daily.practice.business.service.contract;

import com.daily.practice.business.external.service.request.PersistUserExpressionRequest;
import com.daily.practice.business.response.DataResponse_old;
import com.daily.practice.business.response.PersistResponse_old;

public interface IUserExpressionService {
    DataResponse_old getNewExpressionsForUser(int userId);
    DataResponse_old getUserExpressions(int userId);
    PersistResponse_old create(PersistUserExpressionRequest request);
}
