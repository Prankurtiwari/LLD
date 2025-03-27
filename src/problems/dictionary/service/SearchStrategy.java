package problems.dictionary.service;

import problems.dictionary.model.TrieNode;

public interface SearchStrategy {
    boolean search(String word, TrieNode root);
}
