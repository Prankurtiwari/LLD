package problems.rule_engine.model;

import problems.rule_engine.enums.UserType;

import java.util.*;

// RawRuleDefinition.java
public class RawRuleDefinition {
    private String label;
    // map from propertyName to list of category names
    private Map<String, List<UserType>> conditions;

    public RawRuleDefinition() { }

    public String getLabel() { return label; }

    public Map<String, List<UserType>> getConditions() { return conditions; }
}
