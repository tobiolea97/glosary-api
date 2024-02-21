package com.daily.practice.business.service.contract;

import com.daily.practice.business.response.PersistResponse;

public interface IUserTopicService {
    PersistResponse assignTopicToUser(int userId, int topicId);
}
