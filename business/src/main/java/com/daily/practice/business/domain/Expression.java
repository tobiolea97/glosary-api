package com.daily.practice.business.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expression {
    private int id;
    private int expressionTypeId;
    private String title;
    private String cardExample;
    private String definition;
}
