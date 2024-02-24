package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.UserTopic;
import com.daily.practice.data.request.CreateUserTopicRequest;
import com.daily.practice.data.response.PersistResponse;

public interface IUserTopicService {
    PersistResponse<UserTopic> assignTopicToUser(CreateUserTopicRequest request);
}
