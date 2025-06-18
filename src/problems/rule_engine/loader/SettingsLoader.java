package problems.rule_engine.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import problems.rule_engine.model.SettingsScreen;

import java.io.File;

public class SettingsLoader {
    public static SettingsScreen loadSettingsScreen(String filePath, ObjectMapper mapper) throws Exception {
        // Assuming settings.json has the structure matching SettingsScreen: 
        // { "metadata": { ... }, "settings": [ {...}, ... ] }
        return mapper.readValue(new File(filePath), SettingsScreen.class);
    }
}