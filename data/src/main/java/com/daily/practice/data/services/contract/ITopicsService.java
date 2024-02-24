package com.daily.practice.data.services.contract;

import com.daily.practice.data.domain.Topic;
import com.daily.practice.data.domain.TopicType;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.DataResponse2;

import java.util.List;

public interface ITopicsService {
    DataResponse2<List<Topic>> getTopics();
    DataResponse2<List<TopicType>> getTopicTypes();
    DataResponse2<List<Topic>> getTopicsByUserId(int userId);
}
