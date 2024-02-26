package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.Topic;
import com.daily.practice.data.domain.TopicType;
import com.daily.practice.data.response.DataResponse;

import java.util.List;

public interface ITopicsService {
    DataResponse<List<Topic>> getTopics();
    DataResponse<List<TopicType>> getTopicTypes();
    DataResponse<List<Topic>> getTopicsByUserId(int userId);
}
