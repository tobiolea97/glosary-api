package com.daily.practice.business.service;

import com.daily.practice.business.domain.Expression;
import com.daily.practice.business.domain.Stat;
import com.daily.practice.business.domain.Topic;
import com.daily.practice.business.domain.UserExpression;
import com.daily.practice.business.external.service.contract.IDataExternalService;
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
    public DataResponse<List<Stat>> getStats(int userId) {
        DataResponse<List<Stat>> response = new DataResponse<>();
        try {
            List<UserExpression> userExpressions = externalService.getUserExpressionsByUserId(userId).getBody().getData();
            List<Topic> topics = externalService.getTopicsByUserId(userId).getBody().getData();
            List<Expression> expressions = externalService.getExpressionsByUserId(userId,false).getBody().getData();
            List<Stat> stats = new ArrayList<>();
            for(Topic topic : topics) {
                Stat stat = new Stat(topic.getId(), topic.getName(), userExpressions,expressions);
                stats.add(stat);
            }
            response = new DataResponse<>(Results.OK,null,stats, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            response = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return response;
        }
    }
}
