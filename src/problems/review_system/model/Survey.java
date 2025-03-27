package problems.review_system.model;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public record Survey(UUID id, String title, List<Question> questions) {
    public Survey(UUID id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = Collections.unmodifiableList(questions);
    }
}
