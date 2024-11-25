package LandSafe.FamilyGraph;

import java.util.List;
import java.util.LinkedList;

/**
 * A linked list implementation of a weighted, directed graph. 
 * Heavy inspiration from the graph implementation activity.
 */
public class AdjacencyListGraph {
    // Internal class that represents a node that is pointed to and the weight of that edge
    protected static class Edge {
        public int val;

        public int weight;

        public Edge(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }

    private int V;
    private int E;

    private LinkedList<Edge>[] adj;

    public AdjacencyListGraph(int v) {
        if (v < 0) v = 0;
        V = v;
        E = 0;
        adj = (LinkedList<Edge>[]) new List[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Edge>();
        }
    }

    public int Vertices() {
        return V;
    }

    public int Edges() {
        return E;
    }

    public LinkedList<Edge> getAdj(int v) {
        assert(v > 0 && v < V);
        return adj[v];
    }
}