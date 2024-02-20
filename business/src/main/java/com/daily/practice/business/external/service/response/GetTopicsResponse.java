package com.daily.practice.business.external.service.response;

import com.daily.practice.business.domain.Topic;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.List;


@Setter
public class GetTopicsResponse extends APIGetResponse {
    @JsonProperty("data")
    private List<Topic> topics;

    @Override
    public List<?> getData() {
        return topics;
    }
}
