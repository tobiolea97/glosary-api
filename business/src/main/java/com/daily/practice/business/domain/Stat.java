package com.daily.practice.business.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stat {
    private String topicName;
    private int learning;
    private int learnt;
    private int toLearn;
    private int toRefresh;
}
