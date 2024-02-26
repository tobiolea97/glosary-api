package com.daily.practice.business.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public void randomizeOptions(){
        List<String> options = new ArrayList<>();

        options.add(this.option1);

        if(this.option2 != null)
            options.add(this.option2);

        if(this.option3 != null)
            options.add(this.option3);

        if(this.option4 != null)
            options.add(this.option4);

        if(this.option5 != null)
            options.add(this.option5);

        Collections.shuffle(options);

        if(options.size() >= 1)
            this.option1 = options.get(0);
        if(options.size() >= 2)
            this.option2 = options.get(1);
        if(options.size() >= 3)
            this.option3 = options.get(2);
        if(options.size() >= 4)
            this.option4 = options.get(3);
        if(options.size() >= 5)
            this.option5 = options.get(4);
    }

}
