package LandSafe.FamilyGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * A linked list implementation of a weighted, directed graph. 
 * Heavy inspiration from the graph implementation activity.
 * @param <E>
 */
public class AdjacencyListGraph<E> {
    public static final int INIT_SIZE = 4;

    private int vertices;
    private int edges;

    private ArrayList<LinkedList<Edge<E>>> adj;
    private HashMap<Integer, E> nodeAtIndex;
    private HashMap<E, Integer> indexOfNode;

    // Internal class that represents a node that is pointed to and the weight of that edge
    protected static class Edge<E> {
        public E value;

        public int weight;

        public Edge(E val, int weight) {
            this.value = val;
            this.weight = weight;
        }
    }

    public AdjacencyListGraph() {
        vertices = 0;
        edges = 0;
        adj = new ArrayList<>();
        nodeAtIndex = new HashMap<Integer,E>();
        indexOfNode = new HashMap<E, Integer>();
        expandAdjList(INIT_SIZE);
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

    public boolean addEdge(E v1, E v2) {
        return addEdge(v1, v2, 0);
    }

    public boolean addEdge(E v1, E v2, int weight) {
        if (!nodeAtIndex.containsKey(v1) || !nodeAtIndex.containsKey(v2)) {
            throw new IllegalArgumentException("One or both vertices do not exist yet");
        }
        if (getAdj(v1).contains(new Edge<E>(v2, weight))) {
            throw new IllegalArgumentException("Edge already exists");
        }
        Edge<E> newEdge = new Edge<E>(v2, weight);
        getAdj(v1).add(newEdge);
        return true;
    }

    private void expandAdjList(int v) {
        for (int i= 0; i < v; i++) {
            adj.add(new LinkedList<Edge<E>>());
        }
    }

    public static void main(String[] args) {
        AdjacencyListGraph<Integer> G = new AdjacencyListGraph<>();

        System.out.println("Vertices: " + G.vertices() + ", Edges: " + G.edges());

        Integer firstVertex = 0;

        G.addVertex(firstVertex);

        System.out.println("Vertices: " + G.vertices() + ", Edges: " + G.edges()); // test add vertex works

        G.addVertex(0);

        System.out.println("Vertices: " + G.vertices() + ", Edges: " + G.edges()); // test can't add duplicate vertex

        // G.getAdj((Integer) 3);  // should throw IllegalArgumentException when uncommented

        LinkedList<Edge<Integer>> adj1 = G.getAdj((Integer) 0);

        System.out.println("Vertex 0 has no edges: " + adj1.isEmpty());

        Integer secondVertex = 1;

        G.addVertex(secondVertex);

        System.out.println("Vertices: " + G.vertices() + ", Edges: " + G.edges()); // now has two vertices

        G.addEdge(firstVertex, secondVertex);

        System.out.println("Vertex 0 has 1 edge: " + (adj1.size() == 1)); // testing edge creation

        LinkedList<Edge<Integer>> adj2 = G.getAdj(secondVertex);

        System.out.println("Vertex 2 has 1 edge: " + (adj2.size() == 1)); // testing edge is unidirectional
    }
}