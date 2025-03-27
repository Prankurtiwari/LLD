package problems.review_system.controller;

import problems.review_system.model.SurveyResponse;

import java.util.ArrayList;
import java.util.List;

public class ResponsePublisher {
    private final List<ResponseListener> listeners = new ArrayList<>();

    public void subscribe(ResponseListener listener) {
        listeners.add(listener);
    }

    public void publishResponse(SurveyResponse response) {
        listeners.forEach(l -> l.onResponseSubmitted(response));
    }
}
