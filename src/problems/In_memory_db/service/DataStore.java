package problems.In_memory_db.service;

import java.util.List;
import java.util.Map;

public interface DataStore {
    void createTable(String tableName);
    int insert(String tableName, Map<String, String> rowData);
    void update(String tableName, int rowId, Map<String, String> newData);
    void delete(String tableName, int rowId);
    void index(String tableName, String column);
    Map<Integer, Map<String, String>> query(String tableName, String columnValue);
    List<Map<Integer, Map<String, String>>> complexQuery(String tableName, Map<String, String> conditions);
}
