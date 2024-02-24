package com.daily.practice.business.service.contract;

import com.daily.practice.business.response.PersistResponse_old;

public interface IUserTopicService {
    PersistResponse_old assignTopicToUser(int userId, int topicId);
}
