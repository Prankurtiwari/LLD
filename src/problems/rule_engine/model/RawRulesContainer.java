package problems.rule_engine.model;

import java.util.*;

public class RawRulesContainer {
    private List<RawRuleDefinition> rules;

    public RawRulesContainer() { }

    public List<RawRuleDefinition> getRules() { return rules; }
    public void setRules(List<RawRuleDefinition> rules) { this.rules = rules; }
}