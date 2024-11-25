import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import LandSafe.FamilyGraph.*;

public class AdjacencyGraphTest {
    AdjacencyListGraph testGraph;

    @BeforeEach
    void createGraph() {
        testGraph = new AdjacencyListGraph(4);
    }

    @Test
    void assertCreation() {
        assertEquals(4, testGraph.Vertices());
        assertEquals(0, testGraph.Edges());
    }
}
