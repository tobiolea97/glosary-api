package com.daily.practice.business.tools;

import com.daily.practice.business.domain.IAPIResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.List;

public class ExternalServiceResponseParser<T extends IAPIResponse> {
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
