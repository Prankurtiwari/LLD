package problems.rule_engine.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Setting {
    private String title;
    private String description;
    private String label;
    private Integer priority;
    private String category;
    // dynamic additional properties
    private Map<String, Object> extraProperties = new HashMap<>();

    public Setting() {}

    // getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLabel() { return label; }
    public Integer getPriority() { return priority; }
    public String getCategory() { return category; }

    @JsonAnyGetter
    public Map<String, Object> getExtraProperties() {
        return extraProperties;
    }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setLabel(String label) { this.label = label; }
    public void setPriority(Integer priority) { this.priority = priority; }
    public void setCategory(String category) { this.category = category; }

    @JsonAnySetter
    public void addExtraProperty(String name, Object value) {
        extraProperties.put(name, value);
    }
}
