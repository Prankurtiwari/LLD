package problems.in_memory_file_search.model;

import java.util.*;

public class Document {
    private final String id;

    private final String name;
    private final String content;
    private final Map<String, String> metadata;

    private Document(Builder builder) {
        this.id = UUID.randomUUID().toString();
        this.content = builder.content;
        this.metadata = builder.metadata;
        this.name = builder.name;
    }

    // Builder Pattern
    public static class Builder {
        private String content;
        private String name;
        private final Map<String, String> metadata = new HashMap<>();

        public Builder withContent(String content) {
            this.content = content;
            return this;
        }

        public Builder withMetadata(String key, String value) {
            this.metadata.put(key, value);
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Document build() {
            return new Document(this);
        }
    }

    // Getters
    public String getContent() { return content; }
    public Map<String, String> getMetadata() { return metadata; }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
