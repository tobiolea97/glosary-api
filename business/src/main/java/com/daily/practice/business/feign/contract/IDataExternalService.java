package com.daily.practice.business.feign.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface IDataExternalService {
    @GetMapping()
    public ResponseEntity<?> getTopics();
    @GetMapping("types")
    public ResponseEntity<?> getTopicTypes();
}
