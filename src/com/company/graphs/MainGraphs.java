package com.company.graphs;

import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class MainGraphs {

    public static void main(String[] args) {
//        BFS bfs = new BFS();
//        HashMap<String, List<String>> Graph = new HashMap<>();
//        Graph.put("a", new ArrayList(List.of("s", "b")));
//        Graph.put("b", new ArrayList(List.of("a")));
//        Graph.put("s", new ArrayList(List.of("a", "c")));
//        Graph.put("c", new ArrayList(List.of("s", "d", "e")));
//        Graph.put("d", new ArrayList(List.of("c", "e", "f")));
//        Graph.put("e", new ArrayList(List.of("c", "d", "f")));
//        Graph.put("f", new ArrayList(List.of("d", "e")));
//        Graph.put("g", new ArrayList());
//        Map<Integer, HashSet<String>> result = bfs.createParentDistancerepr(Graph);
//        Iterator it = result.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<Integer, HashSet<String>> entry = (Map.Entry) it.next();
//            System.out.print("{ " + entry.getKey() + " : " + entry.getValue() + " } ");
//            System.out.println(" ");
//        }
//        GraphElem graph = new GraphElem(new ArrayList<Integer>(List.of(0, 1, 2, 3)));
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 3);
//        System.out.println(graph.adjacencyList);
//        System.out.println(graph.BFSListSet(0));
        Map<Integer, List<Integer>> adjList = new HashMap<>();
//        adjList.put(0, List.of(1, 2));
//        adjList.put(1, List.of(2, 3));
//        adjList.put(2, List.of(0, 3));
//        System.out.println(ShortestPaths(adjList, 0));
//        adjList.put(0, List.of(1));
//        adjList.put(1, List.of(0, 2, 3));
//        adjList.put(2, List.of(1, 3, 4));
//        adjList.put(3, List.of(1, 2));
//        adjList.put(4, List.of(2, 5));
//        adjList.put(5, List.of(4));
//        System.out.println(CycleUndirectedGraph(adjList));
        adjList.put(0, List.of(1));
        adjList.put(1, new ArrayList<Integer>());
        adjList.put(2, List.of(1, 3));
        adjList.put(3, List.of(4));
        adjList.put(4, List.of(5));
        adjList.put(5, List.of(3));
//        System.out.println(DFSCycleDirectedGraph(adjList));
        System.out.println(BFSCycleDirectedGraph(adjList));
    }

    public static List<Integer> ShortestPaths(Map<Integer, List<Integer>> adjList, Integer source) {
        List<Integer> distances = Arrays.asList(new Integer[adjList.size()]);
        Collections.fill(distances, MAX_VALUE);
        distances.set(source, 0);
        List<Boolean> visited = Arrays.asList(new Boolean[adjList.size()]);
        Collections.fill(visited, Boolean.FALSE);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            Integer Node = queue.poll();
            for (Integer neighbour : adjList.get(Node)) {
                if (!visited.get(neighbour)) {
                    distances.set(neighbour, distances.get(Node) + 1);
                    queue.add(neighbour);
                    visited.set(neighbour, true);
                }
            }
        }
        return distances;
    }

    public static boolean DFS_cycle(Integer node, Map<Integer, List<Integer>> adjList, List<Boolean> visited, Integer parent) {
        visited.set(node, true);
        for (Integer neighbour : adjList.get(node)) {
            if (!visited.get(neighbour)) {
                return DFS_cycle(neighbour, adjList, visited, node);
            } else if (!neighbour.equals(parent)) {
                return true;
            }
        }
        return false;
    }

    public static boolean CycleUndirectedGraph(Map<Integer, List<Integer>> adjList) {
        List<Boolean> visited = Arrays.asList(new Boolean[adjList.size()]);
        Collections.fill(visited, Boolean.FALSE);
        for (Integer elem : adjList.keySet()) {
            if (!visited.get(elem) && DFS_cycle(elem, adjList, visited, -1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean CycleDirectedGraph(Map<Integer, List<Integer>> adjList, Integer Node, List<Boolean> visited, List<Boolean> recStack) {
        visited.set(Node, true);
        recStack.set(Node, true);
        for (Integer neighbor : adjList.get(Node)) {
            if (!visited.get(neighbor) && CycleDirectedGraph(adjList, neighbor, visited, recStack)) {
                return true;
            } else if (recStack.get(neighbor)) {
                return true;
            }
        }
        recStack.set(Node, false);
        return false;
    }

    public static boolean DFSCycleDirectedGraph(Map<Integer, List<Integer>> adjList) {
        List<Boolean> visited = Arrays.asList(new Boolean[adjList.size()]);
        Collections.fill(visited, Boolean.FALSE);
        List<Boolean> recStack = Arrays.asList(new Boolean[adjList.size()]);
        Collections.fill(recStack, Boolean.FALSE);
        for (Integer vertex : adjList.keySet()) {
            if (!visited.get(vertex)) {
                if (CycleDirectedGraph(adjList, vertex, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean BFSDirectedGraph(Map<Integer, List<Integer>> adjList, Integer Node, List<Boolean> visited, List<Integer> seen) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        seen.add(Node);
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            for (Integer neighbor : adjList.get(vertex)) {
                if (!visited.get(neighbor)) {
                    queue.add(neighbor);
                    visited.set(neighbor, true);
                    seen.add(neighbor);
                } else if (seen.contains(neighbor)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean BFSCycleDirectedGraph(Map<Integer, List<Integer>> adjList) {
        List<Boolean> visited = Arrays.asList(new Boolean[adjList.size()]);
        Collections.fill(visited, Boolean.FALSE);
        for (Integer node : adjList.keySet()) {
            if (!visited.get(node)) {
                List<Integer> seen = new ArrayList<>();
                if (BFSDirectedGraph(adjList, node, visited, seen)) {
                    return true;
                }
            }
        }
        return false;
    }
}