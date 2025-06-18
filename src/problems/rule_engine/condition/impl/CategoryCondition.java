package problems.rule_engine.condition.impl;

import problems.rule_engine.condition.Condition;
import problems.rule_engine.enums.UserType;
import problems.rule_engine.model.UserContext;

import java.util.Set;

public class CategoryCondition implements Condition {
    private final Set<UserType> allowedTypes;

    public CategoryCondition(Set<UserType> allowedTypes) {
        this.allowedTypes = allowedTypes;
    }

    @Override
    public boolean matches(UserContext context) {
        for (UserType t : allowedTypes) {
            if (context.hasCategory(t)) {
                return true;
            }
        }
        return false;
    }
}