package com.daily.practice.data.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gaps {
    private int id;
    private int exampleId;
    private int orderNumber;
    private String alternativeAnwser1;
    private String alternativeAnwser2;
    private String alternativeAnwser3;
    private String alternativeAnwser4;
    private String wrongAnwser1;
    private String wrongAnwser2;
    private String wrongAnwser3;
    private String wrongAnwser4;
}
