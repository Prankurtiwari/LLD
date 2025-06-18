package problems.rule_engine.model;

import java.util.List;

public class SettingsScreen {
    private Metadata metadata;
    private List<Setting> settings;

    public SettingsScreen() { }

    public SettingsScreen(Metadata metadata, List<Setting> settings) {
        this.metadata = metadata;
        this.settings = settings;
    }

    public Metadata getMetadata() { return metadata; }
    public void setMetadata(Metadata metadata) { this.metadata = metadata; }
    public List<Setting> getSettings() { return settings; }
    public void setSettings(List<Setting> settings) { this.settings = settings; }
}
