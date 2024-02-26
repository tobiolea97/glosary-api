package com.daily.practice.business.service;

import com.daily.practice.business.domain.UserTopic;
import com.daily.practice.business.external.service.contract.IDataExternalService;
import com.daily.practice.business.external.service.request.CreateUserTopicRequest;
import com.daily.practice.business.external.service.response.PersistResponseParser;
import com.daily.practice.business.response.PersistResponse;
import com.daily.practice.business.response.PersistResponse_old;
import com.daily.practice.business.service.contract.IUserTopicService;
import com.daily.practice.business.utils.Results;
import com.daily.practice.business.utils.Tools;
import com.daily.practice.business.utils.errors.ErrorCodes;
import com.daily.practice.business.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
@RequiredArgsConstructor
public class UserTopicService implements IUserTopicService {
    private final IDataExternalService dataExternalService;
    @Override
    public PersistResponse<UserTopic> assignTopicToUser(int userId, int topicId) {
        PersistResponse<UserTopic> response;
        CreateUserTopicRequest userTopicRequest = new CreateUserTopicRequest(userId, topicId);
        try {
            UserTopic userTopic = dataExternalService.assignTopicToUser(userTopicRequest).getBody().getPersistedObject();
            response = new PersistResponse<>(Results.OK, null, userTopic, HttpStatus.OK);
        } catch (Exception e) {
            response = Tools.getBadRequest(ErrorCodes.COULD_NOT_SAVE_RECORD, ErrorDescriptions.COULD_NOT_SAVE_RECORD);
        }
        return response;
    }
}
