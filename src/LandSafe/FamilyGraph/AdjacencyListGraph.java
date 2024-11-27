package LandSafe.FamilyGraph;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * A linked list implementation of a weighted, directed graph. 
 * Heavy inspiration from the graph implementation activity.
 * @param <E>
 */
public class AdjacencyListGraph<E> {
    // Internal class that represents a node that is pointed to and the weight of that edge
    protected static class Edge<E> {
        public E value;

        public int weight;

        public Edge(E val, int weight) {
            this.value = val;
            this.weight = weight;
        }
    }

    private int vertices;
    private int edges;

    private ArrayList<LinkedList<Edge<E>>> adj;
    private HashMap<Integer, E> nodeAtIndex;
    private HashMap<E, Integer> indexOfNode;

    public AdjacencyListGraph(int v) {
        if (v < 0) throw new IllegalArgumentException("Non-negative integer required");
        vertices = 0;
        edges = 0;
        adj = new ArrayList<>();
        nodeAtIndex = new HashMap<Integer,E>();
        indexOfNode = new HashMap<E, Integer>();
        expandAdjList(v);
    }

    public int vertices() {
        return vertices;
    }

    public int edges() {
        return edges;
    }

    private LinkedList<Edge<E>> getAdj(int index) {
        if (index < 0 || index >= vertices) {
            throw new IllegalArgumentException("Vertex out of bounds");
        }
        return adj.get(index);
    }

    public LinkedList<Edge<E>> getAdj(E vertex) {
        if (!indexOfNode.containsKey(vertex)) {
            System.out.println("Vertex-based adj test");
            throw new IllegalArgumentException("Vertex does not exist yet");
        }; 
        return getAdj(indexOfNode.get(vertex));
    }

    public boolean addVertex(E vertex) {
        if (indexOfNode.containsKey(vertex)) return false;
        if (vertices == adj.size()) expandAdjList(vertices + 1);
        indexOfNode.put(vertex, vertices);
        nodeAtIndex.put(vertices, vertex);
        vertices++;
        return true;
    }

    private void expandAdjList(int v) {
        for (int i= 0; i < v; i++) {
            adj.add(new LinkedList<Edge<E>>());
        }
    }
}