package com.daily.practice.business.service;

import com.daily.practice.business.domain.Expression;
import com.daily.practice.business.domain.Stat;
import com.daily.practice.business.domain.Topic;
import com.daily.practice.business.domain.UserExpression;
import com.daily.practice.business.external.service.contract.IDataExternalService;
import com.daily.practice.business.external.service.response.GetExpressionsResponse;
import com.daily.practice.business.external.service.response.GetResponseParser;
import com.daily.practice.business.external.service.response.GetTopicsResponse;
import com.daily.practice.business.external.service.response.GetUserExpressionsResponse;
import com.daily.practice.business.response.DataResponse;
import com.daily.practice.business.service.contract.IHomeService;
import com.daily.practice.business.utils.Results;
import com.daily.practice.business.utils.Tools;
import com.daily.practice.business.utils.errors.ErrorCodes;
import com.daily.practice.business.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService implements IHomeService {
    private final IDataExternalService externalService;
    @Override
    public DataResponse getStats(int userId) {
        DataResponse response = new DataResponse();
        GetResponseParser<GetUserExpressionsResponse> userExpressionsResponseParser = new GetResponseParser<>();
        GetResponseParser<GetTopicsResponse> topicsResponseParser = new GetResponseParser<>();
        GetResponseParser<GetExpressionsResponse> expressionResponseParser = new GetResponseParser<>();
        try {
            List<UserExpression> userExpressions = (List<UserExpression>) userExpressionsResponseParser.getData(externalService.getUserExpressionsByUserId(userId), GetUserExpressionsResponse.class);
            List<Topic> topics = (List<Topic>) topicsResponseParser.getData(externalService.getTopicsByUserId(userId), GetTopicsResponse.class);
            List<Expression> expressions = (List<Expression>) expressionResponseParser.getData(externalService.getExpressionsByUserId(userId), GetExpressionsResponse.class);
            List<Stat> stats = new ArrayList<>();

            for(Topic topic : topics) {
                Stat stat = new Stat(topic.getId(), topic.getName(), userExpressions,expressions);
                stats.add(stat);
            }

            response = new DataResponse(Results.OK,"",stats, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            response = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return response;
        }
    }
}
