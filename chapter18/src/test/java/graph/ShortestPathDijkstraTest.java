package graph;

import static graph.Vertex.createVertex;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ShortestPathDijkstraTest {

    @Test
    void canFindTheShortestFromSimpleGraph() {
        var aFlightRouteMap = new Graph<String>();
        var boston = createVertex("Boston");
        var atlanta = createVertex("Atlanta");
        atlanta.connectWith(boston, 100);
        aFlightRouteMap.add(atlanta);

        var shortestPah = ShortestPathDijkstra.from(atlanta).to(boston);

        assertEquals(100, shortestPah.distance());
    }

    @Test
    void canFindTheShortestFromTwoLevelDeepGraph() {
        var aFlightRouteMap = new Graph<String>();
        var boston = createVertex("Boston");
        var atlanta = createVertex("Atlanta");
        var chicago = createVertex("chicago");
        atlanta.connectWith(boston, 100);
        boston.connectWith(chicago, 120);
        aFlightRouteMap.add(atlanta);

        var shortestPah = ShortestPathDijkstra.from(atlanta).to(chicago);

        assertEquals(220, shortestPah.distance());
    }

    @Test
    void canFindTheShortestFromFull() {
        var aFlightRouteMap = new Graph<String>();
        var chicago = createVertex("Chicago");
        var denver = createVertex("Denver");
        var boston = createVertex("Boston");
        var elPaso = createVertex("El Paso");
        var atlanta = createVertex("Atlanta");

        elPaso.connectWith(boston, 100);

        denver.connectWith(elPaso, 140);
        denver.connectWith(chicago, 40);

        chicago.connectWith(elPaso, 80);

        boston.connectWith(denver, 180);
        boston.connectWith(chicago, 120);

        atlanta.connectWith(boston, 100);
        atlanta.connectWith(denver, 160);

        aFlightRouteMap.add(atlanta);
        var shortestPah = ShortestPathDijkstra.from(atlanta).to(chicago);

        assertEquals(200, shortestPah.distance());
    }


}
