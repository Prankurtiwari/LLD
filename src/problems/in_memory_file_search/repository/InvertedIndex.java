package problems.in_memory_file_search.repository;

import problems.in_memory_file_search.model.Document;
import problems.in_memory_file_search.service.Tokenizer;

import java.util.*;

public class InvertedIndex {
    private static volatile InvertedIndex instance;
    private final Map<String, List<Document>> index = new HashMap<>();
    private final Map<String, Document> docMap = new HashMap<>();

    private InvertedIndex() {}

    public static InvertedIndex getInstance() {
        if (instance == null) {
            synchronized (InvertedIndex.class) {
                if (instance == null) {
                    instance = new InvertedIndex();
                }
            }
        }
        return instance;
    }

    public void addDocument(Document doc) {
        docMap.put(doc.getId(), doc);
        indexDocument(doc);
    }


    private void indexDocument(Document doc) {
        Tokenizer.tokenize(doc.getContent()).forEach(word -> index.computeIfAbsent(word, k -> new ArrayList<>()).add(doc));
    }

    public List<Document> getDocuments(String term) {
        return index.getOrDefault(term, Collections.emptyList());
    }

    public Document getDocumentId(String id) {
        return docMap.get(id);
    }
}
