package com.daily.practice.data.services;

import com.daily.practice.data.domain.User;
import com.daily.practice.data.domain.UserExpression;
import com.daily.practice.data.repository.contract.IUserExpressionRepository;
import com.daily.practice.data.request.PersistUserExpressionRequest;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.DataResponse2;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.response.PersistResponse2;
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
    public PersistResponse2<UserExpression> create(PersistUserExpressionRequest request) {
        PersistResponse2<UserExpression> persistResponse = new PersistResponse2<>();
        try {
            UserExpression userExpression = new UserExpression(
                    request.getExpressionId(),
                    request.getUserId(),
                    request.getScore(),
                    request.getLastCompleted(),
                    request.isLearn()
            );
            userExpression = userExpressionRepository.create(userExpression);
            persistResponse = new PersistResponse2<>(Results.OK, null, userExpression, HttpStatus.OK);
        } catch (UncategorizedSQLException e) {
            persistResponse = Tools.getBadRequest2(ErrorCodes.SQL_ERROR, e.getCause().getMessage());
        } catch (Exception e) {
            persistResponse = Tools.getBadRequest2(ErrorCodes.COULD_NOT_SAVE_RECORD, ErrorDescriptions.COULD_NOT_SAVE_RECORD);
        } finally {
            return persistResponse;
        }
    }

    @Override
    public DataResponse2<List<UserExpression>> getByUserId(int userId) {
        DataResponse2<List<UserExpression>> dataResponse = new DataResponse2<>();
        try {
            dataResponse = new DataResponse2<>(Results.OK, null, userExpressionRepository.getByUserId(userId), HttpStatus.OK);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError2(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }
}
