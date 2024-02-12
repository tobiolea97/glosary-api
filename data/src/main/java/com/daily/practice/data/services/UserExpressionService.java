package com.daily.practice.data.services;

import com.daily.practice.data.domain.UserExpression;
import com.daily.practice.data.repository.contract.IUserExpressionRepository;
import com.daily.practice.data.request.PersistUserExpressionRequest;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.services.contract.IUserExpressionService;
import com.daily.practice.data.utils.Results;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserExpressionService implements IUserExpressionService {
    private final IUserExpressionRepository userExpressionRepository;

    @Override
    public PersistResponse create(PersistUserExpressionRequest request) {
        PersistResponse persistResponse = new PersistResponse();
        try {
            UserExpression userExpression = new UserExpression(
                    request.getExpressionId(),
                    request.getUserId(),
                    request.getScore(),
                    request.getLastCompleted(),
                    request.isLearn()
            );
            userExpression = userExpressionRepository.create(userExpression);
            persistResponse = new PersistResponse(Results.OK, "", userExpression, HttpStatus.OK);
        } catch (Exception e) {
            persistResponse = new PersistResponse(Results.ERROR, e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return persistResponse;
        }
    }

    @Override
    public DataResponse getByUserId(int userId) {
        DataResponse dataResponse = new DataResponse();
        try {
            dataResponse = new DataResponse(Results.OK, "", userExpressionRepository.getByUserId(userId), HttpStatus.OK);
        } catch (Exception e) {
            dataResponse = new DataResponse(Results.ERROR, e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return dataResponse;
        }
    }
}
