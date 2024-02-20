package com.daily.practice.business.feign.response;

import com.daily.practice.business.domain.IAPIResponse;
import com.daily.practice.business.domain.Topic;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
public class GetTopics extends APIGetResponse implements IAPIResponse {
    @JsonProperty("data")
    private List<Topic> topics;

    @Override
    public List<?> getData() {
        return topics;
    }
}
