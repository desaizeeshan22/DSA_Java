package com.company.graphs;

import java.util.*;

public class MainGraphs {

    public static void main(String[] args) {
        BFS bfs = new BFS();
        HashMap<String, List<String>> Graph = new HashMap<>();
        Graph.put("a", new ArrayList(List.of("s", "b")));
        Graph.put("b", new ArrayList(List.of("a")));
        Graph.put("s", new ArrayList(List.of("a", "c")));
        Graph.put("c", new ArrayList(List.of("s", "d", "e")));
        Graph.put("d", new ArrayList(List.of("c", "e", "f")));
        Graph.put("e", new ArrayList(List.of("c", "d", "f")));
        Graph.put("f", new ArrayList(List.of("d", "e")));
        Graph.put("g", new ArrayList());
        Map<Integer, HashSet<String>> result = bfs.createParentDistancerepr(Graph);
        Iterator it = result.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, HashSet<String>> entry = (Map.Entry) it.next();
            System.out.print("{ " + entry.getKey() + " : " + entry.getValue() + " } ");
            System.out.println(" ");
        }
    }
}