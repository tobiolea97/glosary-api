package com.daily.practice.business.service;

import com.daily.practice.business.domain.Topic;
import com.daily.practice.business.feign.contract.IDataExternalService;
import com.daily.practice.business.feign.response.GetTopicsResponse;
import com.daily.practice.business.service.contract.IWelcomeService;
import com.daily.practice.business.tools.ExternalServiceResponseParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WelcomeService implements IWelcomeService {
    @Autowired
    IDataExternalService dataExternalService;
    @Override
    public Object getWelcomeScreenData() {
        ExternalServiceResponseParser<GetTopicsResponse> topicsResponseParser = new ExternalServiceResponseParser<>();
        ExternalServiceResponseParser<GetTopicsResponse> topicTypesResponseParser = new ExternalServiceResponseParser<>();
        try {
            List<Topic> topics = (List<Topic>) topicsResponseParser.getData(dataExternalService.getTopics(), GetTopicsResponse.class);
            return topics;

        } catch (Exception e) {
            // Handle specific exceptions here
            e.printStackTrace();
        }
        return null;
    }
}
