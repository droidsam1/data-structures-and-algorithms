package graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fixture.GraphFixture;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreOutputStream() {
        System.setOut(originalOut);
    }

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

    @Test
    void breadFirstSearchShouldBehaveAsExample() {
        var aGraph = GraphFixture.buildGraphFromExerciseThree();

        aGraph.traverseBfsAndPerform(vertex -> System.out.printf("%s", vertex.value()));

        assertEquals("abcdefghijklmnop", outContent.toString());
    }


    @Test
    void canPerformADepthFirstSearch() {
        var aGraph = GraphFixture.buildGraphFromExerciseThree();

        aGraph.traverseDfsAndPerform(vertex -> System.out.printf("%s", vertex.value()));

        assertEquals("abejfocgkdhlminp", outContent.toString());
    }

    @Test
    void canFindTheShortestPath() {
        var aFriendShipGraph = GraphFixture.aFriendshipGraphFromExerciseFive();

        var shortestPath = aFriendShipGraph.findShortestPathBetween(
                Vertex.createVertex("Idris"),
                Vertex.createVertex("Lina")
        );

        assertEquals(2, shortestPath.distance());
        assertArrayEquals(new String[]{"Idris", "Kamil", "Lina"}, shortestPath.path().toArray());
    }

}
