package problems.dictionary.service.impl;

import problems.dictionary.model.TrieNode;
import problems.dictionary.service.SearchStrategy;

public class ExactMatchStrategy implements SearchStrategy {
    @Override
    public boolean search(String word, TrieNode root) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.getChildren().get(c);
            if (current == null) return false;
        }
        return current.isEndOfWord();
    }
}
