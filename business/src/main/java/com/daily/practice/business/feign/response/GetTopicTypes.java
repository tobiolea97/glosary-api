package com.daily.practice.business.feign.response;

import com.daily.practice.business.domain.IAPIResponse;
import com.daily.practice.business.domain.Topic;
import com.daily.practice.business.domain.TopicType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GetTopicTypes extends APIGetResponse implements IAPIResponse {
    @JsonProperty("data")
    private List<TopicType> topicTypes;

    @Override
    public List<?> getData() {
        return topicTypes;
    }
}
