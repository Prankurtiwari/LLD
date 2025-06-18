package problems.rule_engine.condition;

import problems.rule_engine.model.UserContext;

public interface Condition {
    boolean matches(UserContext context);
}