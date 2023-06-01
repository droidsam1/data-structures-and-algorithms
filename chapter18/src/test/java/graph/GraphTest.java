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

    @Test
    void canConnectVertex() {
        var aGraph = new Graph<String>();
        var aVertex = new Vertex<>("A label");
        var anotherVertex = new Vertex<>("A different label");
        aVertex.connectWith(anotherVertex);

        aGraph.add(aVertex);

        assertTrue(aGraph.contains(aVertex));
        assertTrue(aGraph.contains(anotherVertex));
    }

    @Test
    void canSearchForDeeperConnections() {
        var aGraph = new Graph<String>();
        var drill = new Vertex<>("drill");
        var hammer = new Vertex<>("hammer");
        var saw = new Vertex<>("saw");
        var knife = new Vertex<>("knife");
        var fork = new Vertex<>("fork");
        drill.connectWith(hammer.connectWith(saw.connectWith(knife.connectWith(fork))));

        aGraph.add(drill);

        assertTrue(aGraph.contains(drill));
        assertTrue(aGraph.contains(saw));
        assertTrue(aGraph.contains(fork));
    }

    @Test
    void canSearchForAVertexEvenInCircularGraphs() {
        var aGraph = new Graph<String>();
        var drill = new Vertex<>("drill");
        var hammer = new Vertex<>("hammer");
        var saw = new Vertex<>("saw");
        var knife = new Vertex<>("knife");
        var fork = new Vertex<>("fork");
        drill.connectWith(hammer.connectWith(saw.connectWith(knife.connectWith(fork.connectWith(drill)))));

        aGraph.add(drill);

        assertTrue(aGraph.contains(fork));
    }


}
