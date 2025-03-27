package problems.review_system.repository;

import problems.review_system.enums.Rating;
import problems.review_system.model.SurveyResponse;
import problems.review_system.service.ScoringStrategy;

import java.util.*;
import java.util.UUID;

public class ScoreRepository {
    private static volatile ScoreRepository instance;

    // In-memory storage for demonstration (replace with DB in real system)
    private final Map<UUID, List<SurveyResponse>> userResponses = new HashMap<>();
    private final Map<UUID, List<SurveyResponse>> surveyResponses = new HashMap<>();
    private final Map<UUID, Double> userAverages = new HashMap<>();
    private final Map<UUID, Double> surveyAverages = new HashMap<>();
    private final ScoringStrategy scoringStrategy;

    private ScoreRepository(ScoringStrategy scoringStrategy) {
        this.scoringStrategy = scoringStrategy;
    }

    public static ScoreRepository getInstance(ScoringStrategy scoringStrategy) {
        if (instance == null) {
            synchronized (ScoreRepository.class) {
                if (instance == null) {
                    instance = new ScoreRepository(scoringStrategy);
                }
            }
        }
        return instance;
    }

    public synchronized void addResponse(SurveyResponse response) {
        updateUserData(response);
        updateSurveyData(response);
    }

    private void updateUserData(SurveyResponse response) {
        UUID userId = response.getUser().id();
        userResponses.computeIfAbsent(userId, k -> new ArrayList<>()).add(response);
        recalculateUserAverage(userId);
    }

    private void updateSurveyData(SurveyResponse response) {
        UUID surveyId = response.getSurvey().id();
        surveyResponses.computeIfAbsent(surveyId, k -> new ArrayList<>()).add(response);
        recalculateSurveyAverage(surveyId);
    }

    private void recalculateUserAverage(UUID userId) {
        List<Rating> allScores = userResponses.get(userId).stream()
                .flatMap(r -> r.getScores().values().stream())
                .toList();
        userAverages.put(userId, scoringStrategy.calculateAverage(allScores));
    }

    private void recalculateSurveyAverage(UUID surveyId) {
        List<Rating> allScores = surveyResponses.get(surveyId).stream()
                .flatMap(r -> r.getScores().values().stream())
                .toList();
        surveyAverages.put(surveyId, scoringStrategy.calculateAverage(allScores));
    }

    public double getUserAverage(UUID userId) {
        return userAverages.getOrDefault(userId, 0.0);
    }

    public double getSurveyAverage(UUID surveyId) {
        return surveyAverages.getOrDefault(surveyId, 0.0);
    }
}
