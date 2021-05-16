package com.example.aviationsystem;

import java.util.*;

public class Graph<T> {


    // edges in graph stored in a hashmap
    private Map<City, LinkedList> map = new HashMap<>();

    // add vertex to graph
    public void addVertex(City city) {
        map.put(city, new LinkedList());
    }

    // add edge between src & dst
    public void addEdge(City source, City destination, boolean bidirectional) {

        if (!map.containsKey(source))
            addVertex(source); // if source doesn't exist as a vertex => add it

        if (!map.containsKey(destination))
            addVertex(destination); // if destination doesn't exist as a vertext => add it

        map.get(source).addCity(destination); // gets the source city's linked list and adds destination city
        if (bidirectional == true) {
            map.get(destination).addCity(source); // if bidirectional, then get linked list of destination and add source
        }

    }

    public int getVertexCount() {
        return map.keySet().size();
    }

    public int getEdgesCount(boolean bidirection) {
        int count = 0;
        for (City city : map.keySet()) { // keySet() returns the number of keys in the hashmap
            count += map.get(city).getSize(); // gets the size of linked list for each city
        }
        if (bidirection == true) {
            count /= 2; // if graph is bidirectional => count / 2
        }

        return count;
    }

    public String hasEdge(City src, City dst) {
        if (map.get(src).contains(dst)) {
            return "Edge found!";
        }
        else {
            return "Edge was NOT found!";
        }
    }


    public String hasVertex(City city) {
        if (map.containsKey(city)) {
            return "vertix found!";
        }
        else {
            return "vertix was NOT found!";
        }
    }


    // Print the adjacency list for all vertices
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        for (City v : map.keySet()) {
            builder.append(v.toString() + ": ");
//             for (T w : map.get(v)) {
//                 builder.append(w.toString() + " ");
//             }
            builder.append(map.get(v).printCities());

            builder.append("\n");
        }

        return (builder.toString());

    }

}