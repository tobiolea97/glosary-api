package com.daily.practice.business.external.service.response;

import com.daily.practice.business.external.service.response.contract.IAPIGetResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class APIGetResponse implements IAPIGetResponse {
    @JsonProperty("result")
    private String result;
    @JsonProperty("errors")
    private String errors;

}
