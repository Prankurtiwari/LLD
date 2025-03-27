package problems.dictionary.controller;

import problems.dictionary.model.TrieNode;
import problems.dictionary.service.SearchStrategy;
import problems.dictionary.service.impl.ExactMatchStrategy;

public class Dictionary {
    private final TrieNode root = new TrieNode();
    private SearchStrategy strategy;

    public Dictionary(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    // Strategy pattern implementation
    public void setSearchStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(c, k -> new TrieNode());
        }
        current.setEndOfWord(true);
    }
    
    public boolean search(String word) {
        return strategy.search(word, root);
    }
    
    // Optional: Auto-complete feature using trie
    public void autoComplete(String prefix) {
        TrieNode node = traverseToPrefix(prefix);
        if (node != null) {
            collectWords(node, new StringBuilder(prefix));
        }
    }
    
    private TrieNode traverseToPrefix(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            current = current.getChildren().get(c);
            if (current == null) return null;
        }
        return current;
    }
    
    private void collectWords(TrieNode node, StringBuilder prefix) {
        if (node.isEndOfWord()) {
            System.out.println(prefix.toString());
        }
        for (char c : node.getChildren().keySet()) {
            prefix.append(c);
            collectWords(node.getChildren().get(c), prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}