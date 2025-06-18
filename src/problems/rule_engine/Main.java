package problems.rule_engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import problems.rule_engine.engine.RuleEngine;
import problems.rule_engine.enums.UserType;
import problems.rule_engine.loader.RuleLoader;
import problems.rule_engine.loader.SettingsLoader;
import problems.rule_engine.model.*;

import java.io.File;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 1. Load base settings + metadata from JSON
        SettingsScreen screen = SettingsLoader.loadSettingsScreen("src/problems/rule_engine/resources/settings.json", mapper);
        List<Setting> baseSettings = screen.getSettings();

        // 2. Load rules from JSON
        String rulesPath = "src/problems/rule_engine/resources/rules.json";
        RawRulesContainer rawRulesContainer = mapper.readValue(new File(rulesPath), RawRulesContainer.class);
        List<Rule> rules = rawRulesContainer.getRules().stream()
                .map(RuleLoader::toRule)
                .toList();

        // 3. Define user context: e.g., FREE and DEPENDENT
        Set<UserType> userCats = EnumSet.of(UserType.ROOT_USER);
        UserContext userContext = new UserContext(userCats);

        // 4. Apply rules
        RuleEngine engine = new RuleEngine();
        engine.applyRules(baseSettings, rules, userContext);

        // 5. Serialize result
        SettingsScreen resultScreen = new SettingsScreen(screen.getMetadata(), baseSettings);
        String outJson = mapper.writeValueAsString(resultScreen);
        System.out.println(outJson);
    }
}
