package com.daily.practice.business.external.service.response;

import com.daily.practice.business.external.service.response.contract.IAPIGetResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.List;

public class GetResponseParser<T extends IAPIGetResponse> {
    ObjectMapper mapper = new ObjectMapper();
    public List<?> getData(ResponseEntity<?> rawResponse, Class<T> clazz) {
        ResponseEntity<LinkedHashMap> response = (ResponseEntity<LinkedHashMap>) rawResponse;
        T mappedResponse;
        try {
            LinkedHashMap responseBody = response.getBody();
            mappedResponse = mapper.readValue(mapper.writeValueAsString(responseBody), clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return mappedResponse.getData();
    }

}
