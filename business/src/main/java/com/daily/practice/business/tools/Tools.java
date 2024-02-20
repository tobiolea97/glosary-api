package com.daily.practice.business.tools;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Tools<T> {
    public static LinkedHashMap getArrayList(ResponseEntity<LinkedHashMap> responseEntity, Class type) {
        LinkedHashMap responseBody = responseEntity.getBody();
        return responseBody;
    }
    
}
