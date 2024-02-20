package com.daily.practice.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TopicType {
    int id;
    String name;
    List<Topic> topics;

    public TopicType() {
        topics = new ArrayList<>();
    }
}
