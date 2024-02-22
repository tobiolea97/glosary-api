package com.daily.practice.business.service;

import com.daily.practice.business.domain.Expression;
import com.daily.practice.business.domain.Stat;
import com.daily.practice.business.domain.Topic;
import com.daily.practice.business.domain.UserExpression;
import com.daily.practice.business.external.service.contract.IDataExternalService;
import com.daily.practice.business.external.service.request.PersistUserExpressionRequest;
import com.daily.practice.business.external.service.response.*;
import com.daily.practice.business.response.DataResponse;
import com.daily.practice.business.response.PersistResponse;
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
    public DataResponse getNewExpressionsForUser(int userId) {
        DataResponse dataResponse = new DataResponse();
        GetResponseParser<GetExpressionsResponse> expressionGetResponseParser = new GetResponseParser<>();
        try {
            List<Expression> expressions = (List<Expression>) expressionGetResponseParser.getData(dataExternalService.getNewExpressions(userId), GetExpressionsResponse.class);
            dataResponse = new DataResponse(Results.OK, "", expressions, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }

    @Override
    public DataResponse getUserExpressions(int userId) {
        DataResponse response = new DataResponse();
        GetResponseParser<GetUserExpressionsResponse> userExpressionsResponseParser = new GetResponseParser<>();
        GetResponseParser<GetTopicsResponse> topicsResponseParser = new GetResponseParser<>();
        try {
            List<UserExpression> userExpressions = (List<UserExpression>) userExpressionsResponseParser.getData(dataExternalService.getUserExpressionsByUserId(userId), GetUserExpressionsResponse.class);
            List<Topic> topics = (List<Topic>) topicsResponseParser.getData(dataExternalService.getTopicsByUserId(userId), GetTopicsResponse.class);

            List<Stat> stats = new ArrayList<>();

            for(Topic topic : topics) {
                Stat stat = new Stat();
                stat.setTopicName(topic.getName());
                stat.setLearning(5);
                stat.setLearnt(2);
                stat.setToLearn(10);
                stat.setToRefresh(3);
                stats.add(stat);
            }

            response = new DataResponse(Results.OK,"",userExpressions,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            response = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return response;
        }

    }

    @Override
    public PersistResponse create(PersistUserExpressionRequest request) {
        PersistResponse persistResponse = new PersistResponse();
        try {
            LinkedHashMap response = (LinkedHashMap) dataExternalService.createUserExpression(request).getBody();
            persistResponse = new PersistResponse(
                    Results.OK, "",
                    PersistResponseParser.getPersistedObject(response),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            persistResponse = Tools.getBadRequest(ErrorCodes.COULD_NOT_SAVE_RECORD, ErrorDescriptions.COULD_NOT_SAVE_RECORD);
        } finally {
            return persistResponse;
        }
    }
}
