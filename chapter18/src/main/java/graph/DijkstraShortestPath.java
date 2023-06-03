package graph;

import static java.util.function.Predicate.not;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstraShortestPath<T> {

    private final Vertex<T> from;
    private final Map<Vertex<T>, PathVertex<T>> pathMap;

    private DijkstraShortestPath(Vertex<T> from) {
        this.from = from;
        this.pathMap = new HashMap<>();
        buildPathMap();
    }

    public static <T> DijkstraShortestPath<T> from(Vertex<T> from) {
        return new DijkstraShortestPath<>(from);
    }

    public GraphPath<T> to(Vertex<T> anotherVertex) {
        List<T> result = new ArrayList<>();
        if (pathMap.get(anotherVertex) == null) {
            return null;
        }
        var current = pathMap.get(anotherVertex);
        result.add(anotherVertex.value());
        while (current != null && !current.from().equals(from)) {
            result.add(current.from().value());
            current = pathMap.get(current.from);
        }
        result.add(from.value());
        Collections.reverse(result);
        return new GraphPath<>(result, pathMap.get(anotherVertex).distance);
    }

    private void buildPathMap() {
        Set<Vertex<T>> visitedVertex = new HashSet<>();
        Deque<Vertex<T>> neighbourhoodStack = new ArrayDeque<>();
        neighbourhoodStack.add(from);
        var distance = 1;
        while (!neighbourhoodStack.isEmpty()) {
            var current = neighbourhoodStack.pop();
            if (visitedVertex.contains(current)) {
                continue;
            }
            processVertex(current, visitedVertex, distance++);
            if (neighbourhoodStack.isEmpty()) {
                neighbourhoodStack.addAll(current.adjacentList().stream().filter(not(current::equals)).toList());
            }
        }
    }

    private void processVertex(Vertex<T> current, Set<Vertex<T>> visitedVertex, int accumulatedDistance) {
        visitedVertex.add(current);
        pathMap.putIfAbsent(current, new PathVertex<>(current, 0));

        var neighbourhood = current.adjacentList();
        for (Vertex<T> tVertex : neighbourhood) {
            pathMap.putIfAbsent(tVertex, new PathVertex<>(current, accumulatedDistance));
            if (pathMap.get(tVertex).distance > accumulatedDistance) {
                pathMap.put(tVertex, new PathVertex<>(current, accumulatedDistance));
            }
        }

    }

    private record PathVertex<T>(Vertex<T> from, int distance) {

    }

}
