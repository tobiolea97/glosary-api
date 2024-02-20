package com.daily.practice.business.tools;

import com.daily.practice.business.feign.response.GetTopicsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Tools<T> {

    public T getArrayList(ResponseEntity<LinkedHashMap> responseEntity, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        LinkedHashMap responseBody = responseEntity.getBody();
        T mappedResponse = null;
        try {
            mappedResponse = mapper.readValue(mapper.writeValueAsString(responseBody), clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return mappedResponse;
    }
}
