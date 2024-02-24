package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.UserTopic;
import com.daily.practice.data.request.CreateUserTopicRequest;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.response.PersistResponse2;

public interface IUserTopicService {
    PersistResponse2<UserTopic> assignTopicToUser(CreateUserTopicRequest request);
}
