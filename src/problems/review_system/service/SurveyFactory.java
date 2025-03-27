package problems.review_system.service;

import problems.review_system.model.Question;
import problems.review_system.model.Survey;

import java.util.*;

public class SurveyFactory {
    public Survey createSurvey(String title, List<String> questions) {
        List<Question> questionList = questions.stream()
                .map(q -> new Question(UUID.randomUUID(), q))
                .toList();

        return new Survey(UUID.randomUUID(), title, questionList);
    }
}
