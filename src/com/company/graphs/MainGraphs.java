package com.company.graphs;

import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

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
//        System.out.println(BFSCycleDetectionUndirected(adjList));
//        System.out.println(CycleUndirectedGraph(adjList));
//        adjList.put(0, List.of(1));
//        adjList.put(1, new ArrayList<Integer>());
//        adjList.put(2, List.of(1, 3));
//        adjList.put(3, List.of(4));
//        adjList.put(4, List.of(5));
//        adjList.put(5, List.of(3));
//        System.out.println(DFSCycleDirectedGraph(adjList));
//        System.out.println(BFSCycleDirectedGraph(adjList));
//        adjList.put(0, List.of(1));
//        adjList.put(1, List.of(3));
//        adjList.put(3, List.of(4));
//        adjList.put(2, List.of(3, 4));
//        adjList.put(4, new ArrayList());
//        System.out.println(TopologicalSortDFSMain(adjList));
        Map<List<String>, Integer> Edges = new HashMap();
//        Edges.put(Arrays.asList("a", "b"), -5);
//        Edges.put(Arrays.asList("a", "c"), 6);
//        Edges.put(Arrays.asList("b", "c"), -4);
//        Edges.put(Arrays.asList("c", "d"), 3);
//        Edges.put(Arrays.asList("d", "b"), -1);
//        System.out.println(BellmanFord(Edges, "a"));
        Edges.put(Arrays.asList("a", "b"), 1);
        Edges.put(Arrays.asList("b", "d"), 2);
        Edges.put(Arrays.asList("a", "c"), 4);
        Edges.put(Arrays.asList("b", "c"), -3);
        Edges.put(Arrays.asList("c", "d"), 3);
        System.out.println(BellmanFordNoNegativeCycleDetection(Edges, "a"));

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
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public static Boolean BFSCycleDetectionUndirected(Map<Integer, List<Integer>> adjList) {
        Queue<Integer> q = new LinkedList();
        Map<Integer, Integer> parent = new HashMap();
        List<Boolean> visited = Arrays.asList(new Boolean[adjList.size()]);
        Collections.fill(visited, FALSE);
        Optional<Integer> firstKey = adjList.keySet().stream().findFirst();
        if (firstKey.isPresent()) {
            q.add(firstKey.get());
            parent.put(firstKey.get(), -1);
            visited.set(firstKey.get(), true);
        }
        while (!q.isEmpty()) {
            Integer vertex = q.poll();
            for (Integer neighbor : adjList.get(vertex)) {
                if (!visited.get(neighbor)) {
                    q.add(neighbor);
                    visited.set(neighbor, true);
                    parent.put(neighbor, vertex);
                } else if (parent.get(vertex) != neighbor) {
                    return true;
                }
            }
        }
        return false;
    }

    //Bellman ford theoretical (-ve weight cycle) not a DAG

    public static Map<String, Integer> BellmanFord(Map<List<String>, Integer> Edges, String source) {
        Map<String, Integer> res = new HashMap();
        Set<String> vertices = new HashSet();
        Edges.keySet().forEach(elem -> {
            vertices.add(elem.get(0));
            vertices.add(elem.get(1));
        });

        for (int i = 0; i <= vertices.size(); i++) {
            res.put("a" + i, 0);
        }
        for (String vertex : vertices) {
            if (!vertex.equals(source)) {
                res.put(vertex + "0", MAX_VALUE);
            }
        }

        for (int i = 1; i <= vertices.size(); i++) {
            for (List<String> edge : Edges.keySet()) {
                if (!edge.get(1).equals(source)) {
                    Integer shortestPathPrevLevel = 0;
                    if (res.get(edge.get(0) + (i - 1)).equals(MAX_VALUE)) {
                        shortestPathPrevLevel = Edges.get(edge);
                    } else {
                        shortestPathPrevLevel = res.get(edge.get(0) + (i - 1)) + Edges.get(edge);
                    }
                    if (res.getOrDefault(edge.get(1) + i, MAX_VALUE) > shortestPathPrevLevel) {
                        res.put(edge.get(1) + i, shortestPathPrevLevel);
                    }
                }
            }
        }
        //|V| no of vertices
        // if a node distance for at most v edges is lesser than the distance to it using at most v-1 edges
        // then the node is a witness and set distance(s,v)=-infinity (as part of a negative weight cycle)
        for (String vertex : vertices) {
            if (!vertex.equals(source)) {
                String PathDistAtmostVedges = vertex + vertices.size();
                String PathDistAtmostVminusOneEdges = vertex + (vertices.size() - 1);
                if (res.get(PathDistAtmostVedges) < res.get(PathDistAtmostVminusOneEdges)) {
                    res.put(PathDistAtmostVedges, MIN_VALUE);
                }
            }
        }
        return res;
    }

    public static Map<String, Integer> BellmanFordNoNegativeCycleDetection(Map<List<String>, Integer> Edges, String source) {
        Map<String, Integer> distances = new HashMap();
        Set<String> vertices = new HashSet();
        Edges.keySet().forEach(elem -> {
            vertices.add(elem.get(0));
            vertices.add(elem.get(1));
        });
        for (String vertex : vertices) {
            if (vertex.equals(source)) {
                distances.put(source, 0);
            } else {
                distances.put(vertex, MAX_VALUE);
            }
        }
        for (int i = 0; i < vertices.size(); i++) {
            for (List<String> edge : Edges.keySet()) {
                Integer shortestPathValue = 0;
                if (distances.get(edge.get(0)).equals(MAX_VALUE)) {
                    shortestPathValue = Edges.get(edge);
                } else {
                    shortestPathValue = distances.get(edge.get(0)) + Edges.get(edge);
                }
                if (distances.get(edge.get(1)) > shortestPathValue) {
                    distances.put(edge.get(1), shortestPathValue);
                }
            }
        }
        return distances;
    }

    public static List<Integer> Dijkstra(List<List<Integer>> adjMatrix, int source) {
        List<Integer> distances = Arrays.asList(new Integer[adjMatrix.size()]);
        Collections.fill(distances, MAX_VALUE);
        distances.set(source, 0);
        List<Boolean> finalized = Arrays.asList(new Boolean[adjMatrix.size()]);
        Collections.fill(finalized, FALSE);
        for (int count = 0; count < adjMatrix.size() - 1; count++) {
            int u = -1;
            for (int v = 0; v < adjMatrix.size(); v++) {
                if (!finalized.get(v) && (u == -1 || distances.get(v) < distances.get(u))) {
                    u = v;
                }
            }
            finalized.set(u, true);
            for (int k = 0; k < adjMatrix.size(); k++) {
                if (!finalized.get(k) && adjMatrix.get(u).get(k)!=0) {
                    distances.set(k, Math.min(distances.get(k),distances.get(u) + adjMatrix.get(u).get(k)));
                }
            }
        }
        return distances;
    }
}

}
