package com.daily.practice.business.external.service.contract;

import org.springframework.http.ResponseEntity;


public interface IDataService {
    public ResponseEntity getTopics();
    public ResponseEntity getTopicTypes();
}
