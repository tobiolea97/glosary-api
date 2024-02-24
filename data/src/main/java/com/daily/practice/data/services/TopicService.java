package com.daily.practice.data.services;

import com.daily.practice.data.domain.Topic;
import com.daily.practice.data.domain.TopicType;
import com.daily.practice.data.domain.UserTopic;
import com.daily.practice.data.repository.contract.ITopicRepository;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.response.DataResponse2;
import com.daily.practice.data.response.PersistResponse;
import com.daily.practice.data.services.contract.ITopicsService;
import com.daily.practice.data.services.contract.IUserTopicService;
import com.daily.practice.data.utils.Results;
import com.daily.practice.data.utils.Tools;
import com.daily.practice.data.utils.errors.ErrorCodes;
import com.daily.practice.data.utils.errors.ErrorDescriptions;
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
    public DataResponse2<List<Topic>> getTopics() {
        DataResponse2<List<Topic>> dataResponse = new DataResponse2();
        try {
            List<Topic> topics = topicRepository.getAllTopics();
            dataResponse = new DataResponse2<>(Results.OK, null, topics, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError2(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }

    @Override
    public DataResponse2<List<TopicType>> getTopicTypes() {
        DataResponse2<List<TopicType>> dataResponse = new DataResponse2<>();
        try {
            List<TopicType> topicTypes = topicRepository.getAllTopicTypes();
            dataResponse = new DataResponse2<>(Results.OK, null, topicTypes, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError2(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }

    @Override
    public DataResponse2<List<Topic>> getTopicsByUserId(int userId) {
        DataResponse2<List<Topic>> dataResponse = new DataResponse2<>();
        try {
            List<Topic> topics = topicRepository.getAllTopicsByUser(userId);
            dataResponse = new DataResponse2<>(Results.OK, null, topics, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError2(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }
}
