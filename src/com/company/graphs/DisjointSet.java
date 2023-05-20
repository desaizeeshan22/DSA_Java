package com.company.graphs;

public class DisjointSet {
    private int[] vertices;
    private int[] parents;

    DisjointSet(int N) {
        this.vertices = new int[N + 1];
        this.parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            vertices[i] = i;
            parents[i] = i;
        }
    }

    public int Find(int node) {
        while (node != this.parents[node]) {
            node = this.parents[node];
        }
        return node;
    }

    public Boolean isSameGroup(int a, int b) {
        return Find(a) == Find(b);
    }

    public void Union(int a, int b) {
        int rootB = Find(b);
        int rootA = Find(a);
        if (rootA == rootB) {
            return;
        }
        this.parents[rootB] = rootA;
        return;
    }
}
