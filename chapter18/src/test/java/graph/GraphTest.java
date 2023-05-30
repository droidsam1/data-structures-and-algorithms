package graph;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GraphTest {

    @Test
    void shouldVertexCanBeAddedToAGraph() {
        var aGraph = new Graph<String>();
        var aVertex = new Vertex<>("A label");

        aGraph.add(aVertex);

        assertNotNull(aGraph);
    }

    @Test
    void canBeEmpty() {
        var aGraph = new Graph<String>();
        assertTrue(aGraph.isEmpty());
    }

    @Test
    void canContainVertex() {
        var aGraph = new Graph<String>();
        var aVertex = new Vertex<>("A label");
        aGraph.add(aVertex);

        assertTrue(aGraph.contains(aVertex));
    }

}
