package com.daily.practice.data.services;

import com.daily.practice.data.domain.UserExpression;
import com.daily.practice.data.repository.contract.IUserExpressionRepository;
import com.daily.practice.data.request.PersistUserExpressionRequest;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.services.contract.IUserExpressionService;
import com.daily.practice.data.utils.Results;
import com.daily.practice.data.utils.Tools;
import com.daily.practice.data.utils.errors.ErrorCodes;
import com.daily.practice.data.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserExpressionService implements IUserExpressionService {
    private final IUserExpressionRepository userExpressionRepository;

    @Override
    public PersistResponse<UserExpression> create(PersistUserExpressionRequest request) {
        PersistResponse<UserExpression> persistResponse = new PersistResponse<>();
        try {
            UserExpression userExpression = new UserExpression(
                    request.getExpressionId(),
                    request.getUserId(),
                    request.getScore(),
                    request.getLastCompleted(),
                    request.isLearn()
            );
            userExpression = userExpressionRepository.create(userExpression);
            persistResponse = new PersistResponse<>(Results.OK, null, userExpression, HttpStatus.OK);
        } catch (UncategorizedSQLException e) {
            persistResponse = Tools.getBadRequest(ErrorCodes.SQL_ERROR, e.getCause().getMessage());
        } catch (Exception e) {
            persistResponse = Tools.getBadRequest(ErrorCodes.COULD_NOT_SAVE_RECORD, ErrorDescriptions.COULD_NOT_SAVE_RECORD);
        } finally {
            return persistResponse;
        }
    }

    @Override
    public DataResponse<List<UserExpression>> getByUserId(int userId) {
        DataResponse<List<UserExpression>> dataResponse = new DataResponse<>();
        try {
            dataResponse = new DataResponse<>(Results.OK, null, userExpressionRepository.getByUserId(userId), HttpStatus.OK);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }
}
