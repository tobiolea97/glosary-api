package com.daily.practice.data.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizItem {
    private int expressionId;
    private int exampleId;
    private String sentence;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
}

