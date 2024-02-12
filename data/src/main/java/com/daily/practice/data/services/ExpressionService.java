package com.daily.practice.data.services;

import com.daily.practice.data.domain.Expression;
import com.daily.practice.data.repository.contract.IExpressionRepository;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.services.contract.IExpressionService;
import com.daily.practice.data.utils.Results;
import com.daily.practice.data.utils.Tools;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpressionService implements IExpressionService {

    private final IExpressionRepository expressionRepository;
    @Override
    public DataResponse getNewExpressionsForUser(int userId) {
        DataResponse dataResponse = new DataResponse();
        try {
            List<Expression> expressions = expressionRepository.getNewExpressionsForUser(userId, 0);
            dataResponse = new DataResponse(Results.OK, "", expressions, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(e, "");
        } finally {
            return dataResponse;
        }
    }

    @Override
    public DataResponse getExpressionById(int expressionId) {
        DataResponse dataResponse = new DataResponse();
        try {
            Expression expression = expressionRepository.getExpressionById(expressionId);
            dataResponse = new DataResponse(Results.OK, "", expression, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(e, "");
        } finally {
            return dataResponse;
        }
    }
}
