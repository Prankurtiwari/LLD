package problems.review_system.service.impl;

import problems.review_system.enums.Rating;
import problems.review_system.service.ScoringStrategy;

import java.util.Collection;

public class SimpleAverageStrategy implements ScoringStrategy {
    @Override
    public double calculateAverage(Collection<Rating> scores) {
        return scores.stream()
                .mapToInt(Rating::getScore)
                .average()
                .orElse(0.0);
    }
}
