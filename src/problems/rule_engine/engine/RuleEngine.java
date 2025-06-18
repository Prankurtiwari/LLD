package problems.rule_engine.engine;

import problems.rule_engine.Strategy.PropertySetterStrategy;
import problems.rule_engine.Strategy.impl.KnownPropertySetter;
import problems.rule_engine.condition.Condition;
import problems.rule_engine.model.Rule;
import problems.rule_engine.model.Setting;
import problems.rule_engine.model.UserContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleEngine {
    private final Map<String, PropertySetterStrategy> setterStrategies = new HashMap<>();

    public RuleEngine() {
    }

    public void applyRules(List<Setting> settings, List<Rule> rules, UserContext context) {
        // Group rules by label for quick lookup
        Map<String, List<Rule>> rulesByLabel = new HashMap<>();
        for (Rule r : rules) {
            rulesByLabel.computeIfAbsent(r.getTargetLabel(), k -> new java.util.ArrayList<>()).add(r);
        }
        for (Setting s : settings) {
            String label = s.getLabel();
            List<Rule> applicable = rulesByLabel.get(label);
            if (applicable == null) continue;
            for (Rule rule : applicable) {
                for (Map.Entry<String, Condition> entry : rule.getPropertyConditions().entrySet()) {
                    String propName = entry.getKey();
                    Condition cond = entry.getValue();
                    if (cond.matches(context)) {
                        PropertySetterStrategy strategy = setterStrategies.get(propName);
                        if (strategy != null) {
                            strategy.apply(s, Boolean.TRUE);
                        } else {
                            // dynamic property → put into extraProperties
                            s.addExtraProperty(propName, Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }
}
