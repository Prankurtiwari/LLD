package problems.dictionary;

import problems.dictionary.controller.Dictionary;
import problems.dictionary.service.impl.ExactMatchStrategy;
import problems.dictionary.service.impl.PrefixMatchStrategy;

public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary(new ExactMatchStrategy());

        // Add words to dictionary
        dictionary.addWord("apple");
        dictionary.addWord("app");
        dictionary.addWord("application");
        dictionary.addWord("aptitude");

        // Exact match search
        System.out.println("Exact search 'app': " + dictionary.search("app")); // true

        // Switch to prefix search strategy
        dictionary.setSearchStrategy(new PrefixMatchStrategy());
        System.out.println("Prefix search 'app': " + dictionary.search("app")); // true

        // Auto-complete demonstration
        System.out.println("\nAuto-complete for 'app':");
        dictionary.autoComplete("app");
    }
}
