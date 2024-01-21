package com.daily.practice.data.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Topic {
    int id;
    String name;
    int topicTypeId;
}


