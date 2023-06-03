package graph;

import static fixture.GraphFixture.aFriendshipGraphFromExerciseFive;
import static fixture.GraphFixture.buildFlightMapFragmented;
import static fixture.GraphFixture.buildFlightMapFromPage376;
import static fixture.GraphFixture.buildGraphFromExerciseOne;
import static fixture.GraphFixture.buildGraphFromExerciseThree;
import static graph.Vertex.createVertex;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        var aVertex = createVertex("A label");

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
        var aVertex = createVertex("A label");
        aGraph.add(aVertex);

        assertTrue(aGraph.contains("A label"));
    }

    @Test
    void canConnectVertex() {
        var aGraph = new Graph<String>();
        var aVertex = createVertex("A label");
        var anotherVertex = createVertex("A different label");
        aVertex.connectWith(anotherVertex);

        aGraph.add(aVertex);

        assertTrue(aGraph.contains("A label"));
        assertTrue(aGraph.contains("A different label"));
    }

    @Test
    void canSearchForDeeperConnections() {
        var aGraph = buildGraphFromExerciseOne();

        assertTrue(aGraph.contains("drill"));
        assertTrue(aGraph.contains("saw"));
        assertTrue(aGraph.contains("fork"));
    }

    @Test
    void canSearchForAVertexEvenInCircularGraphs() {
        var aGraph = buildGraphFromExerciseOne();

        assertTrue(aGraph.contains("fork"));
    }

    @Test
    void breadFirstSearchShouldBehaveAsExample() {
        var aGraph = buildGraphFromExerciseThree();

        aGraph.traverseBfsAndPerform(vertex -> System.out.printf("%s", vertex));

        assertEquals("abcdefghijklmnop", outContent.toString());
    }


    @Test
    void canPerformADepthFirstSearch() {
        var aGraph = buildGraphFromExerciseThree();

        aGraph.traverseDfsAndPerform(vertex -> System.out.printf("%s", vertex));

        assertEquals("abejfocgkdhlminp", outContent.toString());
    }

    @Test
    void canFindTheShortestPath() {
        var aFriendShipGraph = aFriendshipGraphFromExerciseFive();

        var shortestPath = aFriendShipGraph.findShortestPathBetween("Idris", "Lina");

        assertEquals(2, shortestPath.distance());
        assertArrayEquals(new String[]{"Idris", "Kamil", "Lina"}, shortestPath.path().toArray());
    }

    @Test
    void canFindTheShortestPathFromArbitraryVertex() {
        var aFriendShipGraph = aFriendshipGraphFromExerciseFive();

        var shortestPath = aFriendShipGraph.findShortestPathBetween("Ken", "Sasha");

        assertEquals(2, shortestPath.distance());
        assertArrayEquals(new String[]{"Ken", "Marco", "Sasha"}, shortestPath.path().toArray());
    }
    @Test
    void canFindTheShortestPathFromArbitraryVertexAnotherExample() {
        var aFriendShipGraph = aFriendshipGraphFromExerciseFive();

        var shortestPath = aFriendShipGraph.findShortestPathBetween("Idris", "Sasha");

        assertEquals(3, shortestPath.distance());
        assertArrayEquals(new String[]{"Idris", "Kamil", "Lina", "Sasha"}, shortestPath.path().toArray());
    }


    @Test
    void canFindTheShortestFromWeightedGraphs() {
        var aFlightRouteMap = buildFlightMapFromPage376();

        var shortestPath = aFlightRouteMap.findShortestPathBetween("Atlanta", "El Paso");

        assertEquals(280, shortestPath.distance());
    }

    @Test
    void canFindTheShortestFromWeightedGraphsAnotherExample() {
        var aFlightRouteMap = buildFlightMapFromPage376();

        var shortestPath = aFlightRouteMap.findShortestPathBetween("Atlanta", "Chicago");

        assertEquals(200, shortestPath.distance());
    }

    @Test
    void canFindTheShortestFromNoFullyConnectedGraphs() {
        var aFlightRouteMap = buildFlightMapFragmented();

        var shortestPathAmericanSide = aFlightRouteMap.findShortestPathBetween("Atlanta", "Chicago");
        var shortestPathEuropeSide = aFlightRouteMap.findShortestPathBetween("Spain", "Germany");

        assertEquals(200, shortestPathAmericanSide.distance());
        assertEquals(180, shortestPathEuropeSide.distance());

    }

}
