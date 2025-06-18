package problems.rule_engine.Strategy.impl;

import problems.rule_engine.Strategy.PropertySetterStrategy;

public class KnownPropertySetter {
    public static PropertySetterStrategy forBooleanField(String propertyName) {
        return (setting, value) -> {
            boolean boolVal;
            if (value instanceof Boolean) {
                boolVal = (Boolean) value;
            } else {
                boolVal = Boolean.parseBoolean(String.valueOf(value));
            }
            setting.addExtraProperty(propertyName, boolVal);
        };
    }
    public static PropertySetterStrategy forStringField(String propertyName) {
        return (setting, value) -> {
            String str = String.valueOf(value);
            switch (propertyName) {
                case "title": setting.setTitle(str); break;
                case "description": setting.setDescription(str); break;
                case "label": setting.setLabel(str); break;
                case "category": setting.setCategory(str); break;
                default:
                    setting.addExtraProperty(propertyName, str);
            }
        };
    }
    public static PropertySetterStrategy forIntegerField(String propertyName) {
        return (setting, value) -> {
            Integer intVal;
            if (value instanceof Integer) {
                intVal = (Integer) value;
            } else {
                try {
                    intVal = Integer.parseInt(String.valueOf(value));
                } catch (NumberFormatException e) {
                    return;
                }
            }
            if ("priority".equals(propertyName)) {
                setting.setPriority(intVal);
            } else {
                setting.addExtraProperty(propertyName, intVal);
            }
        };
    }
}