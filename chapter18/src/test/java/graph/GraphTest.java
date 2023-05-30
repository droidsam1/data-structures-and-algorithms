package graph;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GraphTest {


    @Test
    void shouldCreateAGraph() {

        var aGraph = new Graph();

        assertNotNull(aGraph);

    }

}
