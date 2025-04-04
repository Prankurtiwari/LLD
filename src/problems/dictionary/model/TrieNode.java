package problems.dictionary.model;

import java.util.*;

public class TrieNode {
    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean isEndOfWord;

    public Map<Character, TrieNode> getChildren() { return children; }
    public boolean isEndOfWord() { return isEndOfWord; }
    public void setEndOfWord(boolean end) { isEndOfWord = end; }
}
