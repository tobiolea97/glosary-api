package com.daily.practice.business.external.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserTopicRequest {
    int userId;
    int topicId;
}
