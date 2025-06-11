package problems.In_memory_db;

import problems.In_memory_db.service.DataStore;
import problems.In_memory_db.service.impl.InMemoryDataStore;

import java.util.HashMap;
import java.util.*;/*
  *
  * Question: Implement an In-Memory Relational Data Store
Objective: Design and implement a simple in-memory relational data store with CRUD operations and indexing.
* The data store should be able to support basic operations like creating tables, inserting and updating rows, deleting rows, and indexing on a single column.
*
For simplicity, assume:
All fields in a table are of type string.
You do not need to implement SQL parsing. Methods will be called directly.
Each row will have a unique,Auto-Gen-ID
  *
  * */


class DatabaseMain {

   public static void main(String[] args) {
        DataStore dataStore = new InMemoryDataStore();

        // Create a table
        dataStore.createTable("users");

        dataStore.createTable("product");

        // Insert rows
        Map<String,String> user1 = new HashMap<>();
        user1.put("name", "prankur");
        user1.put("age", "30");

        Map<String,String> user2 = new HashMap<>();
        user2.put("name", "Prakarsh");
        user2.put("age", "25");

        Map<String,String> user3 = new HashMap<>();
        user3.put("name", "Shubhi");
        user3.put("age", "21");


        Map<String,String> product1 = new HashMap<>();
        product1.put("name", "iphone");
        product1.put("cost", "30");

        Map<String,String> product2 = new HashMap<>();
        product2.put("name", "samsung");
        product2.put("cost", "25");




        int user1Id = dataStore.insert("users", user1); // ID 1
        int user2Id = dataStore.insert("users", user2); // ID 2
        int user3Id = dataStore.insert("users", user3); // ID 2

        int product1Id = dataStore.insert("product", product1); // ID 1
        int product2Id = dataStore.insert("product", product2); // ID 2

        // Complex Query Example
        Map<String,String> conditions = new HashMap<>();
        conditions.put("age", "30");

        List<Map<Integer ,Map<String,String>>> complexResults = dataStore.complexQuery("users", conditions);

        System.out.println(complexResults);  // Output: [{1={name=Alice , age=30}}]

        // Additional Complex Query Example
        conditions.clear();
        conditions.put("name", "prankur");
        List<Map<Integer ,Map<String,String>>> complexResults2 = dataStore.complexQuery("users", conditions);

        System.out.println(complexResults2);  // Output: [{2={name=Bob , age=25}}]


        // Update a row
        Map<String,String> updatedUser1 = new HashMap<>();
        updatedUser1.put("age", "31");

        dataStore.update("users", user1Id, updatedUser1);

        // Delete a row
        dataStore.delete("users", user2Id);

        // Indexing
        dataStore.index("users", "name");

        // Querying
        Map<Integer, Map<String,String>> result = dataStore.query("users", "Shubhi");
        System.out.println(result);  // Output: {1={name=Alice, age=31}}

   }
}