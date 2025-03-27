package problems.in_memory_file_search;

import problems.in_memory_file_search.model.Document;
import problems.in_memory_file_search.controller.SearchEngine;
import problems.in_memory_file_search.service.impl.ExactMatchStrategy;

import java.util.*;

public class DocumentSearchApp {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine(new ExactMatchStrategy());

        // Add documents
        Document doc1 = new Document.Builder()
                .withContent("The quick brown FOX jumps")
                .withMetadata("author", "John")
                .withName("DOC 1")
                .build();
        engine.addDocument(doc1);

        Document doc2 = new Document.Builder()
                .withContent("The fox dog sleeps")
                .withMetadata("author", "Jane")
                .withName("DOC 2")
                .build();

        engine.addDocument(doc2);

        // Perform search
        List<Document> results = engine.searchByWords("fox");
        results.forEach(doc ->
                System.out.println("Found in document: " + doc.getName())
        );

        Document findDocId = engine.searchByID(doc1.getId());

        System.out.println(findDocId.getContent());

    }
}
