package problems.in_memory_file_search.service.impl;

import problems.in_memory_file_search.model.Document;
import problems.in_memory_file_search.repository.InvertedIndex;
import problems.in_memory_file_search.service.SearchStrategy;

import java.util.*;

public class ExactMatchStrategy implements SearchStrategy {
    @Override
    public List<Document> search(String query, InvertedIndex index) {
        return index.getDocuments(query.toLowerCase());
    }
}
