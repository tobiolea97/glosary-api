package com.daily.practice.business.domain;

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
    private String alternativeAnswer1;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;
    private String correctAnswer;
}
