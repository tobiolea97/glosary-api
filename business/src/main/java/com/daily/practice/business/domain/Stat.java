package com.daily.practice.business.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stat {
    private int topicId;
    private String topicName;
    private int learning;
    private int learnt;
    private int toLearn;
    private int toRefresh;

    public Stat(int topicId, String topicName, List<UserExpression> userExpressions, List<Expression> expressions) {
        this.topicId = topicId;
        this.topicName = topicName;
        int learning = 0, learnt = 0, toLearn = 0, toRefresh = 0;
        for(UserExpression userExpression : userExpressions) {
            Expression expression = expressions.stream().filter(e -> e.getId() == userExpression.getExpressionId()).findFirst().get();
            if(topicId == expression.getExpressionTypeId()) {
                if (userExpression.getScore() >= 1 && userExpression.getScore() <= 4)
                    learning++;
                if (userExpression.getScore() == 5)
                    learnt++;
                if(userExpression.getScore() == 0)
                    if(userExpression.getLastCompleted() == null)
                        toLearn++;
                    else
                        learning++;
            }
        }
        this.setLearning(learning);
        this.setLearnt(learnt);
        this.setToLearn(toLearn);
        this.setToRefresh(toRefresh);
    }
}
