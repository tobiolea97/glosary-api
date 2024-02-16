package com.daily.practice.business.service;

import com.daily.practice.business.domain.Topic;
import com.daily.practice.business.feign.contract.IDataExternalService;
import com.daily.practice.business.service.contract.IWelcomeService;
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
        try {
            LinkedHashMap responseMap = (LinkedHashMap) dataExternalService.getTopics().getBody();
            List<LinkedHashMap<String, Object>> list = (List<LinkedHashMap<String, Object>>) responseMap.get("list");


            ArrayList<Topic> topicsList = new ArrayList<>();
            for (LinkedHashMap<String, Object> item : list) {
                int id = (int) item.get("id");
                String name = (String) item.get("name");
                int topicTypeId = (int) item.get("topicTypeId");

                // Create a new Topic object and add it to the list
                Topic topic = new Topic(id, name, topicTypeId);
                topicsList.add(topic);
            }
            InputStream inputStream = null;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
