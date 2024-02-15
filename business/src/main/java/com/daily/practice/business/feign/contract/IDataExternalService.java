package com.daily.practice.business.feign.contract;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("DP-DATA-SERVICE")
public interface IDataExternalService {
    @GetMapping("topics")
    public ResponseEntity<?> getTopics();
    @GetMapping("topics/types")
    public ResponseEntity<?> getTopicTypes();
}
