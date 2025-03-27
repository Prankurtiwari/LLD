package problems.dictionary.service.impl;

import problems.dictionary.model.TrieNode;
import problems.dictionary.service.SearchStrategy;

public class PrefixMatchStrategy implements SearchStrategy {
    @Override
    public boolean search(String prefix, TrieNode root) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            current = current.getChildren().get(c);
            if (current == null) return false;
        }
        return true;
    }
}
