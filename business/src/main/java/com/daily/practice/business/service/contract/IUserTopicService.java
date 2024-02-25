package com.daily.practice.business.service.contract;

import com.daily.practice.business.domain.UserTopic;
import com.daily.practice.business.response.PersistResponse;
import com.daily.practice.business.response.PersistResponse_old;

public interface IUserTopicService {
    PersistResponse<UserTopic> assignTopicToUser(int userId, int topicId);
}
