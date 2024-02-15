package com.daily.practice.business.feign.contract;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

@FeignClient("DP-DATA-SERVICE")
public interface IDataService {
    public ResponseEntity getTopics();
    public ResponseEntity getTopicTypes();
}
