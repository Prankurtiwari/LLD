package problems.review_system.controller;

import problems.review_system.model.SurveyResponse;

public interface ResponseListener {
    void onResponseSubmitted(SurveyResponse response);
}
