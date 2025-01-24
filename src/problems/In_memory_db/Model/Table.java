package problems.In_memory_db.Model;

import java.util.*;

public class Table {
    private final Map<Integer, Map<String, String>> rows = new HashMap<>();
    private final Map<String, Map<String, Integer>> index = new HashMap<>();

    public void insertRow(int id, Map<String, String> data) {
        rows.put(id, data);
        for (String key : data.keySet()) {
            indexRow(key, data.get(key), id);
        }
    }

    public void updateRow(int id, Map<String, String> newData) {
        if (rows.containsKey(id)) {
            Map<String, String> existingRow = rows.get(id);
            for (String key : existingRow.keySet()) {
                removeFromIndex(key, existingRow.get(key));
            }
            existingRow.putAll(newData);
            for (String key : existingRow.keySet()) {
                indexRow(key, existingRow.get(key), id);
            }
        } else {
            throw new IllegalArgumentException("Row with ID " + id + " does not exist.");
        }
    }

    public void deleteRow(int id) {
        if (rows.containsKey(id)) {
            Map<String, String> existingRow = rows.remove(id);
            for (String key : existingRow.keySet()) {
                removeFromIndex(key, existingRow.get(key));
            }
        } else {
            throw new IllegalArgumentException("Row with ID " + id + " does not exist.");
        }
    }

    public void createIndex(String column) {
        index.put(column, new HashMap<>());
        for (Map.Entry<Integer, Map<String, String>> entry : rows.entrySet()) {
            String value = entry.getValue().get(column);
            if (value != null) {
                index.get(column).put(value, entry.getKey());
            }
        }
    }

    private void indexRow(String column, String value, int id) {
        if (!index.containsKey(column)) {
            index.put(column, new HashMap<>());
        }
        index.get(column).put(value, id);
    }

    private void removeFromIndex(String column, String value) {
        if (index.containsKey(column)) {
            index.get(column).remove(value);
        }
    }

    public Map<Integer, Map<String, String>> query(String columnValue) {
        Map<Integer, Map<String,String>> result = new HashMap<>();
        for (Map.Entry<String,Integer> entry : index.values().stream()
                .flatMap(map -> map.entrySet().stream())
                .filter(e -> e.getKey().equals(columnValue))
                .toList()) {
            result.put(entry.getValue(), rows.get(entry.getValue()));
        }
        return result;
    }

    public List<Map<Integer, Map<String,String>>> complexQuery(Map<String,String> conditions) {
        List<Map<Integer, Map<String,String>>> results = new ArrayList<>();
        for (Map.Entry<Integer ,Map<String,String>> entry : rows.entrySet()) {
            boolean match = true;
            for (Map.Entry<String,String> condition : conditions.entrySet()) {
                // Check if the condition matches
                if (!entry.getValue().getOrDefault(condition.getKey(), "").equals(condition.getValue())) {
                    match = false;
                    break;
                }
            }
            if (match) {
                results.add(Map.of(entry.getKey(), entry.getValue()));
            }
        }
        return results;
    }
}