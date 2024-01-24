package com.daily.practice.data.services;

import com.daily.practice.data.domain.UserTopic;
import com.daily.practice.data.repository.contract.IUserTopicRepository;
import com.daily.practice.data.request.CreateUserTopicRequest;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.services.contract.IUserTopicService;
import com.daily.practice.data.utils.Results;
import com.daily.practice.data.utils.Tools;
import com.daily.practice.data.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTopicService implements IUserTopicService {


    private final IUserTopicRepository userTopicRepository;
    @Override
    public PersistResponse assignTopicToUser(CreateUserTopicRequest request) {
        PersistResponse persistResponse = new PersistResponse();
        try {
            UserTopic userTopic = userTopicRepository.create(request.getUserId(), request.getTopicId());
            persistResponse = new PersistResponse(Results.OK, "", userTopic, HttpStatus.OK);
        } catch (Exception e) {
            persistResponse = Tools.getBadRequest(e, ErrorDescriptions.COULD_NOT_SAVE_RECORD);
        } finally {
            return persistResponse;
        }
    }
}
