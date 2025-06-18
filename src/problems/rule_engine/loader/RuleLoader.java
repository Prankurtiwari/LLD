package problems.rule_engine.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import problems.rule_engine.condition.Condition;
import problems.rule_engine.condition.impl.CategoryCondition;
import problems.rule_engine.enums.UserType;
import problems.rule_engine.model.RawRuleDefinition;
import problems.rule_engine.model.RawRulesContainer;
import problems.rule_engine.model.Rule;

import java.util.*;
import java.util.stream.Collectors;

public class RuleLoader {
    /**
     * Convert RawRuleDefinition to Rule.
     * Skips invalid category names silently or logs a warning.
     */
    public static Rule toRule(RawRuleDefinition raw) {
        String label = raw.getLabel();
        Map<String, Condition> propConds = new HashMap<>();
        if (raw.getConditions() != null) {
            for (Map.Entry<String, List<UserType>> entry : raw.getConditions().entrySet()) {
                String propName = entry.getKey();
                List<UserType> catNames = entry.getValue();
                Set<UserType> types = new HashSet<>();
                for (UserType cat : catNames) {
                    try {
                        types.add(cat);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Warning: unknown user type in rule: " + cat);
                    }
                }
                if (!types.isEmpty()) {
                    propConds.put(propName, new CategoryCondition(types));
                }
            }
        }
        return new Rule(label, propConds);
    }

    public static List<Rule> loadRulesFromJson(String json, ObjectMapper mapper) throws Exception {
        RawRulesContainer container = mapper.readValue(json, RawRulesContainer.class);
        if (container.getRules() == null) {
            return Collections.emptyList();
        }
        return container.getRules().stream()
                .map(RuleLoader::toRule)
                .collect(Collectors.toList());
    }
}