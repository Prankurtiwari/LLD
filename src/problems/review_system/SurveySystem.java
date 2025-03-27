package problems.review_system;

import problems.review_system.controller.ResponsePublisher;
import problems.review_system.enums.Rating;
import problems.review_system.model.Survey;
import problems.review_system.model.SurveyResponse;
import problems.review_system.model.User;
import problems.review_system.repository.ScoreRepository;
import problems.review_system.service.SurveyFactory;
import problems.review_system.service.impl.SimpleAverageStrategy;

import java.util.*;

public class SurveySystem {

    public static void main(String[] args) {
        // Initialize components
        SurveyFactory factory = new SurveyFactory();
        ScoreRepository repository = ScoreRepository.getInstance(new SimpleAverageStrategy());
        ResponsePublisher publisher = new ResponsePublisher();

        // Setup observer
        publisher.subscribe(repository::addResponse);

        // Create survey
        Survey survey = factory.createSurvey("Employee Satisfaction", List.of(
                "Work-life balance",
                "Career growth opportunities"
        ));

        // Create user
        User user = new User(UUID.randomUUID(), "john_doe");

        // Submit response with ratings using enum
        Map<UUID, Rating> scores = new HashMap<>();
        scores.put(survey.questions().get(0).id(), Rating.THREE);
        scores.put(survey.questions().get(1).id(), Rating.ONE);

        SurveyResponse response = new SurveyResponse(user, survey, scores);
//        repository.addResponse(response);
        publisher.publishResponse(response);

        // Get averages
        System.out.println("User Average: " + user.username() + " " + repository.getUserAverage(user.id()));
        System.out.println("Survey Average: " + survey.title() + " " + repository.getSurveyAverage(survey.id()));


    }
}
