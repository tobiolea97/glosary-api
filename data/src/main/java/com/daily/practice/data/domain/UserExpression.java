package com.daily.practice.data.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UserExpression {
    private int expressionId;
    private int userId;
    private int score;
    private LocalDate lastCompleted;
    private boolean learn;
}
