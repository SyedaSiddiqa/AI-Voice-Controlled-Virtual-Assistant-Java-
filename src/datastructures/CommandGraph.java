package datastructures;

import java.util.*;

public class CommandGraph {

    Map<String, List<String>> graph = new HashMap<>();

    public void addEdge(String from, String to) {
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
    }
}
