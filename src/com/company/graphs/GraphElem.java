package com.company.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphElem {
    public Map<Integer, ArrayList<Integer>> adjacencyList;

    public GraphElem() {
        this.adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
    }

    public GraphElem(ArrayList<Integer> Vertices) {
        this.adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
        for (Integer elem : Vertices) {
            this.adjacencyList.put(elem, new ArrayList<Integer>());
        }
    }

    public void addEdge(int u, int v) {
        if (!this.adjacencyList.get(u).contains(v)) {
            this.adjacencyList.get(u).add(v);
        }
        if (!this.adjacencyList.get(v).contains(u)) {
            this.adjacencyList.get(v).add(u);
        }
    }

    public boolean valueInPreviouLevelSet(Map<Integer, List<Integer>> LevelSets, int Vertex) {
        for (Integer key : LevelSets.keySet()) {
            if (LevelSets.get(key).contains(Vertex)) {
                return true;
            }
        }

        return false;
    }

    public Map<Integer, List<Integer>> BFSListSet(int indexSource) {
        int dist = 0;
        Map<Integer, List<Integer>> LevelSets = new HashMap<Integer, List<Integer>>();
        LevelSets.put(0, List.of(indexSource));
        for (Integer i : adjacencyList.keySet()) {
            List<Integer> resSet = new ArrayList<Integer>();
            for (Integer vertex : adjacencyList.get(i)) {
                if (!valueInPreviouLevelSet(LevelSets, vertex)) {
                    resSet.add(vertex);
                }
            }
            if (!resSet.isEmpty()) {
                dist += 1;
                LevelSets.put(dist, resSet);
            }
        }
        return LevelSets;
    }
}
