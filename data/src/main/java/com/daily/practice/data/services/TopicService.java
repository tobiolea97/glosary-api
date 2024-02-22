package com.daily.practice.data.services;

import com.daily.practice.data.domain.Topic;
import com.daily.practice.data.domain.TopicType;
import com.daily.practice.data.domain.UserTopic;
import com.daily.practice.data.repository.contract.ITopicRepository;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.services.contract.ITopicsService;
import com.daily.practice.data.services.contract.IUserTopicService;
import com.daily.practice.data.utils.Results;
import com.daily.practice.data.utils.Tools;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TopicService implements ITopicsService {

    private final ITopicRepository topicRepository;
    @Override
    public DataResponse getTopics() {
        List<Topic> topics;
        DataResponse dataResponse = new DataResponse();
        try {
            topics = topicRepository.getAllTopics();
            dataResponse = new DataResponse(Results.OK, "", topics, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(e, "");
        } finally {
            return dataResponse;
        }
    }

    @Override
    public DataResponse getTopicTypes() {
        List<TopicType> topicTypes;
        DataResponse dataResponse = new DataResponse();
        try {
            topicTypes = topicRepository.getAllTopicTypes();
            dataResponse = new DataResponse(Results.OK, "", topicTypes, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(e, "");
        } finally {
            return dataResponse;
        }
    }

    @Override
    public DataResponse getTopicsByUserId(int userId) {
        List<Topic> topics;
        DataResponse dataResponse = new DataResponse();
        try {
            topics = topicRepository.getAllTopicsByUser(userId);
            dataResponse = new DataResponse(Results.OK, "", topics, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(e, "");
        } finally {
            return dataResponse;
        }
    }
}
