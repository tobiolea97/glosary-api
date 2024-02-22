package com.daily.practice.business.external.service.response;

import com.daily.practice.business.external.service.response.contract.IAPIGetResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.List;

public class GetResponseParser<T extends IAPIGetResponse> {

    public List<?> getData(ResponseEntity<?> rawResponse, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

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
