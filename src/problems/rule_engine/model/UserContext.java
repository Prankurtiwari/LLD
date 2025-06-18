package problems.rule_engine.model;

import problems.rule_engine.enums.UserType;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class UserContext {
    private final Set<UserType> categories;

    public UserContext(Set<UserType> categories) {
        // make a defensive copy
        this.categories = EnumSet.copyOf(categories);
    }
    public boolean hasCategory(UserType type) {
        return categories.contains(type);
    }
    public Set<UserType> getCategories() {
        return Collections.unmodifiableSet(categories);
    }
}