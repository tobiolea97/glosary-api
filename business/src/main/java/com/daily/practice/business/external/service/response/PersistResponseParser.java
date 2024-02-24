package com.daily.practice.business.external.service.response;

import com.daily.practice.business.response.PersistResponse_old;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;

public class PersistResponseParser {

    public static Object getPersistedObject(LinkedHashMap rawResponse) {
        PersistResponse_old mappedResponse;
        ObjectMapper mapper = new ObjectMapper();
        try {
            mappedResponse = mapper.readValue(mapper.writeValueAsString(rawResponse), PersistResponse_old.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return mappedResponse.getPersistedObject();
    }
}
