package com.daily.practice.business.service;

import com.daily.practice.business.domain.Topic;
import com.daily.practice.business.domain.TopicType;
import com.daily.practice.business.feign.contract.IDataExternalService;
import com.daily.practice.business.feign.response.APIGetResponse;
import com.daily.practice.business.feign.response.GetTopicTypes;
import com.daily.practice.business.feign.response.GetTopics;
import com.daily.practice.business.service.contract.IWelcomeService;
import com.daily.practice.business.tools.ExternalServiceResponseParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WelcomeService implements IWelcomeService {
    @Autowired
    IDataExternalService dataExternalService;
    @Override
    public Object getWelcomeScreenData() {
        ExternalServiceResponseParser<GetTopics> topicsResponseParser = new ExternalServiceResponseParser<>();
        ExternalServiceResponseParser<GetTopicTypes> topicTypesResponseParser = new ExternalServiceResponseParser<>();
        try {
            List<Topic> topics = (List<Topic>) topicsResponseParser.getData(dataExternalService.getTopics(), GetTopics.class);
            List<TopicType> topicTypes = (List<TopicType>) topicTypesResponseParser.getData(dataExternalService.getTopicTypes(), GetTopicTypes.class);

            for (TopicType topicType : topicTypes) {
                for (Topic topic : topics) {
                    if (topicType.getId() == topic.getTopicTypeId()) {
                        topicType.getTopics().add(topic);
                    }
                }
            }

            return topicTypes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
