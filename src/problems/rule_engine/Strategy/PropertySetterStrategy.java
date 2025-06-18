package problems.rule_engine.Strategy;

import problems.rule_engine.model.Setting;

public interface PropertySetterStrategy {
    void apply(Setting setting, Object value);
}