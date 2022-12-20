package com.company.graphs;

import java.util.*;

import static java.lang.Boolean.FALSE;
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
//        adjList.put(0, List.of(1));
//        adjList.put(1, new ArrayList<Integer>());
//        adjList.put(2, List.of(1, 3));
//        adjList.put(3, List.of(4));
//        adjList.put(4, List.of(5));
//        adjList.put(5, List.of(3));
//        System.out.println(DFSCycleDirectedGraph(adjList));
//        System.out.println(BFSCycleDirectedGraph(adjList));
        adjList.put(0, List.of(1));
        adjList.put(1, List.of(3));
        adjList.put(3, List.of(4));
        adjList.put(2, List.of(3,4));
        adjList.put(4,new ArrayList());
       System.out.println(TopologicalSortDFSMain(adjList));
    }

    public static List<Integer> ShortestPaths(Map<Integer, List<Integer>> adjList, Integer source) {
        List<Integer> distances = Arrays.asList(new Integer[adjList.size()]);
        Collections.fill(distances, MAX_VALUE);
        distances.set(source, 0);
        List<Boolean> visited = Arrays.asList(new Boolean[adjList.size()]);
        Collections.fill(visited, FALSE);
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
        Collections.fill(visited, FALSE);
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
        Collections.fill(visited, FALSE);
        List<Boolean> recStack = Arrays.asList(new Boolean[adjList.size()]);
        Collections.fill(recStack, FALSE);
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
        Collections.fill(visited, FALSE);
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

//    Topological sort using Kahn's algorithm(BFS based)
//    Calculate the indegrees of every vertex (every vertex is like a job)
//    an indegree indicates number of jobs which need to be complete before arriving to the particular job(vertex)
//    jobs with indegree 0 are run first aka not dependent on other jobs
//    store 0 indegree jobs in the queue use BFS to go to the dependent jobs aka all neighbours and reduce indegree by 1
//    if indegree becomes 0 then push the job(vertex) to the queue to be processed as all its dependent jobs are complete
//    pop the job from the queue and repeat the process on all the neighbouring jobs(vertices) of the popped job

    public static List<Integer> BFS_Topological_Sort(Map<Integer, List<Integer>> adjList) {
        List<Integer> indegree = Arrays.asList(new Integer[adjList.size()]);
        Collections.fill(indegree, 0);
        for (Integer node : adjList.keySet()) {
            adjList.entrySet().forEach(elem -> {
                        if (elem.getValue().contains(node)) {
                            indegree.set(node, indegree.get(node) + 1);
                        }
                    }
            );
        }
        Queue<Integer> q = new LinkedList();
        indegree.forEach(elem -> {
            if (elem.equals(0)) {
                q.add(indegree.indexOf(elem));
            }
        });
        List<Integer> result = new ArrayList();
        while (!q.isEmpty()) {
            Integer node = q.poll();
            result.add(node);
            for (Integer neighbor : adjList.get(node)) {
                indegree.set(node, indegree.get(node) - 1);
                if (indegree.get(node).equals(0)) {
                    q.add(node);
                }
            }
        }
        return result;
    }

    public static boolean CycleDetectionBFSKahnAlgorithm(Map<Integer, List<Integer>> adjList) {
        List<Integer> indegree = Arrays.asList(new Integer[adjList.keySet().size()]);
        Collections.fill(indegree, 0);
        for (Integer entry : adjList.keySet()) {
            adjList.entrySet().forEach(elem -> {
                if (elem.getValue().contains(entry)) {
                    indegree.set(entry, indegree.get(entry) + 1);
                }
            });
        }
        Queue<Integer> q = new LinkedList();
        int count = 0;
        while (!q.isEmpty()) {
            Integer u = q.poll();
            for (Integer neighbor : adjList.get(u)) {
                indegree.set(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor).equals(0)) {
                    q.add(neighbor);
                }
            }
            count++;
        }
        return count != adjList.keySet().size();
    }

    public static void DFSTopologicalSort(Map<Integer, List<Integer>> adjList, Integer node, List<Boolean> visited, Stack<Integer> stack) {
        visited.set(node, true);
        for (Integer neighbor : adjList.get(node)) {
            if (!visited.get(neighbor)) {
                DFSTopologicalSort(adjList, neighbor, visited, stack);
            }
        }
        stack.add(node);
        return;
    }

    public static List<Integer> TopologicalSortDFSMain(Map<Integer, List<Integer>> adjList) {
        List<Boolean> visited = Arrays.asList(new Boolean[adjList.size()]);
        Collections.fill(visited, FALSE);
        Stack<Integer> stack = new Stack();
        for (Integer vertex : adjList.keySet()) {
            if (!visited.get(vertex)) {
                DFSTopologicalSort(adjList, vertex, visited, stack);
            }
        }
        List<Integer> res = new ArrayList();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}