package problems.in_memory_file_search.service;

import java.util.*;

public class Tokenizer {  // Factory Pattern
    private static final List<String> STOP_WORDS = List.of("the", "and", "a");
    
    public static List<String> tokenize(String text) {
        return Arrays.stream(text.toLowerCase().split("\\W+"))
            .filter(word -> !STOP_WORDS.contains(word))
            .toList();
    }
}