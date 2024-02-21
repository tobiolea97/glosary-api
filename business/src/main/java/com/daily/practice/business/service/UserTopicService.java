package com.daily.practice.business.service;

import com.daily.practice.business.external.service.contract.IDataExternalService;
import com.daily.practice.business.external.service.request.CreateUserTopicRequest;
import com.daily.practice.business.response.PersistResponse;
import com.daily.practice.business.service.contract.IUserTopicService;
import com.daily.practice.business.utils.Results;
import com.daily.practice.business.utils.Tools;
import com.daily.practice.business.utils.errors.ErrorCodes;
import com.daily.practice.business.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTopicService implements IUserTopicService {
    private final IDataExternalService dataExternalService;
    @Override
    public PersistResponse assignTopicToUser(int userId, int topicId) {
        PersistResponse persistResponse = new PersistResponse();
        try {
            CreateUserTopicRequest userTopicRequest = new CreateUserTopicRequest(userId, topicId);
            Object response = dataExternalService.assignTopicToUser(userTopicRequest);
            persistResponse = new PersistResponse(Results.OK, "", response, HttpStatus.OK);
        } catch (Exception e) {
            persistResponse = Tools.getBadRequest(ErrorCodes.COULD_NOT_SAVE_RECORD, ErrorDescriptions.COULD_NOT_SAVE_RECORD);
        } finally {
            return persistResponse;
        }
    }
}
