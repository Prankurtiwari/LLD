package problems.In_memory_db.service.impl;

import problems.In_memory_db.Model.Table;
import problems.In_memory_db.service.DataStore;

import java.util.*;

public class InMemoryDataStore implements DataStore {
    private final Map<String, Table> tables = new HashMap<>();
    private int autoIncrementId = 1;

    @Override
    public void createTable(String tableName) {
        if (!tables.containsKey(tableName)) {
            tables.put(tableName, new Table());
        } else {
            throw new IllegalArgumentException("Table " + tableName + " already exists.");
        }
    }

    @Override
    public int insert(String tableName, Map<String, String> rowData) {
        validateTableExists(tableName);
        int rowId = autoIncrementId++;
        tables.get(tableName).insertRow(rowId, rowData);
        return rowId;
    }

    @Override
    public void update(String tableName, int rowId, Map<String, String> newData) {
        validateTableExists(tableName);
        tables.get(tableName).updateRow(rowId, newData);
    }

    @Override
    public void delete(String tableName, int rowId) {
        validateTableExists(tableName);
        tables.get(tableName).deleteRow(rowId);
    }

    @Override
    public void index(String tableName, String column) {
        validateTableExists(tableName);
        tables.get(tableName). createIndex(column);
    }

    @Override
    public Map<Integer, Map<String, String>> query(String tableName, String columnValue) {
        validateTableExists(tableName);
        return tables.get(tableName).query(columnValue);
    }

    @Override
    public List<Map<Integer, Map<String, String>>> complexQuery(String tableName, Map<String, String> conditions) {
        validateTableExists(tableName);
        return tables.get(tableName).complexQuery(conditions);
    }

    private void validateTableExists(String tableName) {
        if (!tables.containsKey(tableName)) {
            throw new IllegalArgumentException("Table " + tableName + " does not exist.");
        }
    }
}