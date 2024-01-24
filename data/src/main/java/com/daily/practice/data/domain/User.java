package com.daily.practice.data.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int questionsPerQuiz;
}
