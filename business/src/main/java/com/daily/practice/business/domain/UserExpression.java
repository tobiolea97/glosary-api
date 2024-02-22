package com.daily.practice.business.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserExpression {
    private int expressionId;
    private int userId;
    private int score;
    private LocalDate lastCompleted;
    private boolean learn;
}
