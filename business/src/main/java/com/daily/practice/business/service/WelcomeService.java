package com.daily.practice.business.service;

import com.daily.practice.business.domain.Topic;
import com.daily.practice.business.domain.TopicType;
import com.daily.practice.business.external.service.contract.IDataExternalService;
import com.daily.practice.business.external.service.response.GetTopicTypesResponse;
import com.daily.practice.business.external.service.response.GetTopicsResponse;
import com.daily.practice.business.response.DataResponse;
import com.daily.practice.business.service.contract.IWelcomeService;
import com.daily.practice.business.external.service.ResponseParser;
import com.daily.practice.business.utils.Results;
import com.daily.practice.business.utils.Tools;
import com.daily.practice.business.utils.errors.ErrorCodes;
import com.daily.practice.business.utils.errors.ErrorDescriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WelcomeService implements IWelcomeService {
    @Autowired
    IDataExternalService dataExternalService;
    @Override
    public DataResponse getWelcomeScreenData() {
        DataResponse dataResponse = new DataResponse();
        ResponseParser<GetTopicsResponse> topicsResponseParser = new ResponseParser<>();
        ResponseParser<GetTopicTypesResponse> topicTypesResponseParser = new ResponseParser<>();
        try {
            List<Topic> topics = (List<Topic>) topicsResponseParser.getData(dataExternalService.getTopics(), GetTopicsResponse.class);
            List<TopicType> topicTypes = (List<TopicType>) topicTypesResponseParser.getData(dataExternalService.getTopicTypes(), GetTopicTypesResponse.class);
            for (TopicType topicType : topicTypes) {
                for (Topic topic : topics) {
                    if (topicType.getId() == topic.getTopicTypeId()) {
                        topicType.getTopics().add(topic);
                    }
                }
            }
            dataResponse = new DataResponse(Results.OK, "", topicTypes, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            dataResponse = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        } finally {
            return dataResponse;
        }
    }
}
