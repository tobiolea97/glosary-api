package com.daily.practice.business.service;

import com.daily.practice.business.domain.Expression;
import com.daily.practice.business.domain.Stat;
import com.daily.practice.business.domain.Topic;
import com.daily.practice.business.domain.UserExpression;
import com.daily.practice.business.external.service.contract.IDataExternalService;
import com.daily.practice.business.external.service.request.PersistUserExpressionRequest;
import com.daily.practice.business.external.service.response.*;
import com.daily.practice.business.response.DataResponse;
import com.daily.practice.business.response.DataResponse_old;
import com.daily.practice.business.response.PersistResponse_old;
import com.daily.practice.business.service.contract.IUserExpressionService;
import com.daily.practice.business.utils.Results;
import com.daily.practice.business.utils.Tools;
import com.daily.practice.business.utils.errors.ErrorCodes;
import com.daily.practice.business.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserExpressionService implements IUserExpressionService {
    private final IDataExternalService dataExternalService;
    @Override
    public DataResponse<List<Expression>> getNewExpressionsForUser(int userId) {
        DataResponse<List<Expression>> response;
        try {
            DataResponse<List<Expression>> getNewExpressionsResponse = dataExternalService.getNewExpressions(userId).getBody();
            List<Expression> expressions;
            if (getNewExpressionsResponse != null) {
                expressions = getNewExpressionsResponse.getData();
            } else throw new Exception();

            response = new DataResponse<>(Results.OK, null, expressions, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            response = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        }
        return response;
    }

    @Override
    public DataResponse<List<Stat>> getUserExpressions(int userId) {
        DataResponse<List<Stat>> response;
        try {
            List<UserExpression> userExpressions = dataExternalService.getUserExpressionsByUserId(userId).getBody().getData();
            List<Topic> topics = dataExternalService.getTopicsByUserId(userId).getBody().getData();
            List<Expression> expressions = dataExternalService.getExpressionsByUserId(userId).getBody().getData();
            List<Stat> stats = new ArrayList<>();
            for(Topic topic : topics) {
                Stat stat = new Stat(topic.getId(), topic.getName(), userExpressions,expressions);
                stats.add(stat);
            }
            response = new DataResponse<>(Results.OK,null,stats,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            response = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        }
        return response;
    }

    @Override
    public PersistResponse_old create(PersistUserExpressionRequest request) {
        PersistResponse_old persistResponse = new PersistResponse_old();
        try {
            LinkedHashMap response = (LinkedHashMap) dataExternalService.createUserExpression(request).getBody();
            persistResponse = new PersistResponse_old(
                    Results.OK, "",
                    PersistResponseParser.getPersistedObject(response),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            persistResponse = Tools.getBadRequest2(ErrorCodes.COULD_NOT_SAVE_RECORD, ErrorDescriptions.COULD_NOT_SAVE_RECORD);
        } finally {
            return persistResponse;
        }
    }
}
