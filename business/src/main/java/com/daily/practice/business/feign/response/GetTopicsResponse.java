package com.daily.practice.business.feign.response;

import com.daily.practice.business.domain.Topic;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetTopicsResponse {
    @JsonProperty("result")
    private String result;
    @JsonProperty("errors")
    private String errors;
    @JsonProperty("list")
    private List<Topic> list;
}
