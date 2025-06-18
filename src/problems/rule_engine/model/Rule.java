package problems.rule_engine.model;

import problems.rule_engine.condition.Condition;

import java.util.Map;

public class Rule {
    private final String targetLabel;
    private final Map<String, Condition> propertyConditions;

    public Rule(String targetLabel, Map<String, Condition> propertyConditions) {
        this.targetLabel = targetLabel;
        this.propertyConditions = propertyConditions;
    }
    public String getTargetLabel() { return targetLabel; }
    public Map<String, Condition> getPropertyConditions() { return propertyConditions; }
}