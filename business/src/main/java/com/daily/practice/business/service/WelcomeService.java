package com.daily.practice.business.service;

import com.daily.practice.business.domain.Topic;
import com.daily.practice.business.feign.contract.IDataExternalService;
import com.daily.practice.business.feign.response.GetTopicsResponse;
import com.daily.practice.business.service.contract.IWelcomeService;
import com.daily.practice.business.tools.Tools;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WelcomeService implements IWelcomeService {
    @Autowired
    IDataExternalService dataExternalService;
    @Override
    public Object getWelcomeScreenData() {
        Tools<GetTopicsResponse> tools = new Tools<>();
        try {
            ResponseEntity<LinkedHashMap> rawResponse = (ResponseEntity<LinkedHashMap>) dataExternalService.getTopics();
            GetTopicsResponse response = tools.getArrayList(rawResponse, GetTopicsResponse.class);
            return response.getList();
        } catch (Exception e) {
            // Handle specific exceptions here
            e.printStackTrace();
        }
        return null;
    }
}
