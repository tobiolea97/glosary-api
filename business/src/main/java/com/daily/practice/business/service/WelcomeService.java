package com.daily.practice.business.service;

import com.daily.practice.business.domain.Topic;
import com.daily.practice.business.domain.TopicType;
import com.daily.practice.business.external.service.contract.IDataExternalService;
import com.daily.practice.business.external.service.response.GetTopicTypesResponse;
import com.daily.practice.business.external.service.response.GetTopicsResponse;
import com.daily.practice.business.response.DataResponse_old;
import com.daily.practice.business.response.DataResponse;
import com.daily.practice.business.service.contract.IWelcomeService;
import com.daily.practice.business.external.service.response.GetResponseParser;
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
    public DataResponse<List<TopicType>> getWelcomeScreenData() {
        DataResponse<List<TopicType>> response;
        try {
            List<Topic> topics = dataExternalService.getTopics().getBody().getData();
            List<TopicType> topicTypes = dataExternalService.getTopicTypes().getBody().getData();
            for (TopicType topicType : topicTypes) {
                for (Topic topic : topics) {
                    if (topicType.getId() == topic.getTopicTypeId()) {
                        topicType.getTopics().add(topic);
                    }
                }
            }
            response = new DataResponse<>(Results.OK, null, topicTypes, HttpStatus.ACCEPTED);
        } catch(Exception e) {
            response = Tools.getDataResponseError(ErrorCodes.ERROR_WHEN_RETREIVING_DATA, ErrorDescriptions.ERROR_WHEN_RETREIVING_DATA);
        }
        return response;
    }


}
