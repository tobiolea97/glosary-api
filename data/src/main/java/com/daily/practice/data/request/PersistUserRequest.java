package com.daily.practice.data.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersistUserRequest {
    private int id;
    private String firstName;
    private String lastName;
    private int questionsPerQuiz;
}
