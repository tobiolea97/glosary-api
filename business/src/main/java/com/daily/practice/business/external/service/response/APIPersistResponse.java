package com.daily.practice.business.external.service.response;

import com.daily.practice.business.external.service.response.contract.IAPIPersistResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIPersistResponse implements IAPIPersistResponse {
    @JsonProperty("result")
    private String result;
    @JsonProperty("errors")
    private String errors;
    @JsonProperty("persistedObject")
    private Object persistedObject;
}
