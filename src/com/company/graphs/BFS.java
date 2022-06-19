package com.company.graphs;

import java.util.*;

public class BFS {

    public Map<Integer, HashSet<String>> createParentDistancerepr(
            HashMap<String, List<String>> Graph) {
        if (Graph.isEmpty()) {
            return null;
        }
        LinkedHashMap<Integer, HashSet<String>> result =
                new LinkedHashMap<Integer, HashSet<String>>();
        Map.Entry<String, List<String>> sourceNode = Graph.entrySet().iterator().next();
        HashSet<String> firstLevelSet = new HashSet<String>();
        firstLevelSet.add(sourceNode.getKey());
        result.put(0, firstLevelSet);
        Iterator it = Graph.entrySet().iterator();
        int dist = 0;
        while (it.hasNext()) {
            Map.Entry<String, List<String>> Node = (Map.Entry) it.next();
            HashSet<String> valueSet = new HashSet<String>();
            if (Node.getValue().isEmpty()) {
                dist = -11111;
                result.put(dist, valueSet);
            } else {
                List<String> NodeList = Node.getValue();
                for (String Value : NodeList) {
                    boolean contains = false;
                    for (int i = 0; i <= dist; i++) {
                        if (result.getOrDefault(i, new HashSet<String>()).contains(Value)) {
                            contains = true;
                            break;
                        }
                    }
                    if (!contains) {
                        valueSet.add(Value);
                    }
                }
            }
            if (!valueSet.isEmpty()) {
                dist += 1;
                result.put(dist, valueSet);
            }
        }
        return result;
    }
}
