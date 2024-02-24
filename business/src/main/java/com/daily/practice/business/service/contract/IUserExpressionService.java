package com.daily.practice.business.service.contract;

import com.daily.practice.business.domain.Expression;
import com.daily.practice.business.domain.Stat;
import com.daily.practice.business.external.service.request.PersistUserExpressionRequest;
import com.daily.practice.business.response.DataResponse;
import com.daily.practice.business.response.DataResponse_old;
import com.daily.practice.business.response.PersistResponse_old;

import java.util.List;

public interface IUserExpressionService {
    DataResponse<List<Expression>> getNewExpressionsForUser(int userId);
    DataResponse<List<Stat>> getUserExpressions(int userId);
    PersistResponse_old create(PersistUserExpressionRequest request);
}
