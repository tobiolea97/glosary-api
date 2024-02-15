package com.daily.practice.business.feign.contract;

import org.springframework.http.ResponseEntity;


public interface IDataService {
    public ResponseEntity getTopics();
    public ResponseEntity getTopicTypes();
}
