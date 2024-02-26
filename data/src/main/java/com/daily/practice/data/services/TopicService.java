package com.daily.practice.data.services;

import com.daily.practice.data.domain.Topic;
import com.daily.practice.data.domain.TopicType;
import com.daily.practice.data.repository.contract.ITopicRepository;
import com.daily.practice.data.response.DataResponse;
import com.daily.practice.data.services.contract.ITopicsService;
import com.daily.practice.data.utils.Results;
import com.daily.practice.data.utils.Tools;
import com.daily.practice.data.utils.errors.ErrorCodes;
import com.daily.practice.data.utils.errors.ErrorDescriptions;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicService implements ITopicsService {

    private final ITopicRepository topicRepository;
    @Override
    public DataResponse<List<Topic>> getTopics() {
        DataResponse<List<Topic>> dataResponse = new DataResponse();
        try {
            List<Topic> topics = topicRepository.getAllTopics();
            dataResponse = new DataResponse<>(Results.OK, null, topics, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }

    @Override
    public DataResponse<List<TopicType>> getTopicTypes() {
        DataResponse<List<TopicType>> dataResponse = new DataResponse<>();
        try {
            List<TopicType> topicTypes = topicRepository.getAllTopicTypes();
            dataResponse = new DataResponse<>(Results.OK, null, topicTypes, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }

    @Override
    public DataResponse<List<Topic>> getTopicsByUserId(int userId) {
        DataResponse<List<Topic>> dataResponse = new DataResponse<>();
        try {
            List<Topic> topics = topicRepository.getAllTopicsByUser(userId);
            dataResponse = new DataResponse<>(Results.OK, null, topics, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }
}
