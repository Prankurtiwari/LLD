package problems.review_system.model;

import problems.review_system.enums.Rating;
import problems.review_system.exception.IllegalRatingException;

import java.util.*;

public class SurveyResponse {
    private final User user;
    private final Survey survey;
    private final Map<UUID, Rating> questionScores; // Question ID to Rating

    public SurveyResponse(User user, Survey survey, Map<UUID, Rating> scores) {
        validateScores(scores.values());
        this.user = user;
        this.survey = survey;
        this.questionScores = new HashMap<>(scores);
    }

    private void validateScores(Collection<Rating> scores) {
        for (Rating score : scores) {
            if (score == null) {
                throw new IllegalRatingException("Scores cannot be null");
            }
        }
    }

    // Getters
    public Map<UUID, Rating> getScores() { return Collections.unmodifiableMap(questionScores); }

    public User getUser() {
        return user;
    }


    public Survey getSurvey() {
        return survey;
    }
}
