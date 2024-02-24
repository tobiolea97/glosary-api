package com.daily.practice.business.service;

import com.daily.practice.business.external.service.contract.IDataExternalService;
import com.daily.practice.business.external.service.request.CreateUserTopicRequest;
import com.daily.practice.business.external.service.response.PersistResponseParser;
import com.daily.practice.business.response.PersistResponse_old;
import com.daily.practice.business.service.contract.IUserTopicService;
import com.daily.practice.business.utils.Results;
import com.daily.practice.business.utils.Tools;
import com.daily.practice.business.utils.errors.ErrorCodes;
import com.daily.practice.business.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
@RequiredArgsConstructor
public class UserTopicService implements IUserTopicService {
    private final IDataExternalService dataExternalService;
    @Override
    public PersistResponse_old assignTopicToUser(int userId, int topicId) {
        PersistResponse_old persistResponse = new PersistResponse_old();
        CreateUserTopicRequest userTopicRequest = new CreateUserTopicRequest(userId, topicId);
        try {
            LinkedHashMap response = (LinkedHashMap) dataExternalService.assignTopicToUser(userTopicRequest).getBody();
            persistResponse = new PersistResponse_old(
                    Results.OK, "",
                    PersistResponseParser.getPersistedObject(response),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            persistResponse = Tools.getBadRequest2(ErrorCodes.COULD_NOT_SAVE_RECORD, ErrorDescriptions.COULD_NOT_SAVE_RECORD);
        } finally {
            return persistResponse;
        }
    }
}
