package com.company;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;

public class JsonNodeComparator {
    public static void main(String[] args) {
        String jsonString1 = "{\"name\": \"John\", \"age\": 30}";
        String jsonString2 = "{\"age\": 30, \"name\": \"John\", \"sexo\": \"test\"}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node1 = objectMapper.readTree(jsonString1);
            JsonNode node2 = objectMapper.readTree(jsonString2);

            boolean isEqual = compareJsonNodes(node1, node2);
            System.out.println("Are the JSON strings equal? " + isEqual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean compareJsonNodes(JsonNode node1, JsonNode node2) {
        if (node1.size() != node2.size()) {
            return false;
        }

        if (node1.isObject() && node2.isObject()) {
            Iterator<String> fieldNames = node1.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                if (!node2.has(fieldName) || !compareJsonNodes(node1.get(fieldName), node2.get(fieldName))) {
                    return false;
                }
            }
            return true;
        } else if (node1.isArray() && node2.isArray()) {
            for (int i = 0; i < node1.size(); i++) {
                if (!compareJsonNodes(node1.get(i), node2.get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return node1.equals(node2);
        }
    }
}