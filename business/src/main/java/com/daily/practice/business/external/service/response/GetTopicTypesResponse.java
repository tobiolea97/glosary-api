package com.daily.practice.business.external.service.response;

import com.daily.practice.business.domain.TopicType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetTopicTypesResponse extends APIGetResponse {
    @JsonProperty("data")
    private List<TopicType> topicTypes;

    @Override
    public List<?> getData() {
        return topicTypes;
    }
}
