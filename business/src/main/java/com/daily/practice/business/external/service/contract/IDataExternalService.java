package com.daily.practice.business.external.service.contract;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("DP-DATA-SERVICE")
public interface IDataExternalService {
    @GetMapping("topics")
    ResponseEntity<?> getTopics();
    @GetMapping("topics/types")
    ResponseEntity<?> getTopicTypes();
}
