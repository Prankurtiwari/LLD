package problems.in_memory_file_search.controller;

import problems.in_memory_file_search.model.Document;
import problems.in_memory_file_search.repository.InvertedIndex;
import problems.in_memory_file_search.service.SearchStrategy;

import java.util.*;

public class SearchEngine {
    private final InvertedIndex index = InvertedIndex.getInstance();
    private final SearchStrategy strategy;

    public SearchEngine(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    
    public void addDocument(Document doc) {
        index.addDocument(doc);
    }
    
    public List<Document> searchByWords(String query) {
        return strategy.search(query, index);
    }
    public Document searchByID(String id) {
        return index.getDocumentId(id);
    }

}