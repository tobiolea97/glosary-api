package com.daily.practice.data.services;

import com.daily.practice.data.domain.Example;
import com.daily.practice.data.domain.Expression;
import com.daily.practice.data.repository.contract.IExpressionRepository;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.DataResponse2;
import com.daily.practice.data.services.contract.IExpressionService;
import com.daily.practice.data.utils.Results;
import com.daily.practice.data.utils.Tools;
import com.daily.practice.data.utils.errors.ErrorCodes;
import com.daily.practice.data.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpressionService implements IExpressionService {

    private final IExpressionRepository expressionRepository;
    @Override
    public DataResponse2<List<Expression>> getNewExpressionsForUser(int userId) {
        DataResponse2<List<Expression>> dataResponse = new DataResponse2<>();
        try {
            List<Expression> expressions = expressionRepository.getNewExpressionsForUser(userId, 0);
            dataResponse = new DataResponse2<>(Results.OK, null, expressions, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError2(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }

    @Override
    public DataResponse2<Expression> getExpressionById(int expressionId) {
        DataResponse2<Expression> dataResponse = new DataResponse2<>();
        try {
            Expression expression = expressionRepository.getExpressionById(expressionId);
            dataResponse = new DataResponse2<Expression>(Results.OK, null, expression, HttpStatus.ACCEPTED);
        } catch(EmptyResultDataAccessException e) {
            dataResponse = Tools.getDataResponseError2(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.NON_EXISTING_RECORD);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError2(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }

    @Override
    public DataResponse2<List<Expression>> getExpressionsByUserId(int userId) {
        DataResponse2<List<Expression>> dataResponse = new DataResponse2<>();
        try {
            List<Expression> expressions = expressionRepository.getExpressionsByUserId(userId);
            dataResponse = new DataResponse2(Results.OK, null, expressions, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError2(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }
}
