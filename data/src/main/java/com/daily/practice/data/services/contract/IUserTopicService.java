package com.daily.practice.data.services.contract;

import com.daily.practice.data.request.CreateUserTopicRequest;
import com.daily.practice.data.response.PersistResponse;

public interface IUserTopicService {
    PersistResponse assignTopicToUser(CreateUserTopicRequest request);
}
