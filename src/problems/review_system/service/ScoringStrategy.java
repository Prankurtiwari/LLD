package problems.review_system.service;

import problems.review_system.enums.Rating;

import java.util.Collection;

public interface ScoringStrategy {
    double calculateAverage(Collection<Rating> scores);
}
