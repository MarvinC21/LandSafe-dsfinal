import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import LandSafe.FamilyGraph.*;

public class GraphTest {
    AdjacencyListGraph<Integer> testGraph;

    @BeforeEach
    void createGraph() {
        testGraph = new AdjacencyListGraph<Integer>();
    }

    @Test
    void assertCreation() {
        assertEquals(0, testGraph.vertices());
        assertEquals(0, testGraph.edges());
    }

    @Test
    void testGetAdjacentError() {
        assertThrows(IllegalArgumentException.class, () -> testGraph.getAdj((4)));
    }

    @Test
    void testAddVertex(){
        testGraph.addVertex(42);
        assertEquals(1, testGraph.vertices());
    }
}
