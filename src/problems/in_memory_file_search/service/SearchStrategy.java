package problems.in_memory_file_search.service;

import problems.in_memory_file_search.model.Document;
import problems.in_memory_file_search.repository.InvertedIndex;

import java.util.List;

public interface SearchStrategy {
    List<Document> search(String query, InvertedIndex index);
}
