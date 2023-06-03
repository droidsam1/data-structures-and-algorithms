package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class ShortestPathDijkstra<T> {

    private final Map<Vertex<T>, VertexTableEntry<T>> shortestPathTable;
    private final Vertex<T> from;

    private ShortestPathDijkstra(Vertex<T> from) {
        this.from = from;
        this.shortestPathTable = buildPathTableFrom(from);
    }

    public static <T> ShortestPathDijkstra<T> from(Vertex<T> from) {
        return new ShortestPathDijkstra<>(from);
    }

    private Map<Vertex<T>, VertexTableEntry<T>> buildPathTableFrom(Vertex<T> from) {
        final var vertexPathTable = new HashMap<Vertex<T>, VertexTableEntry<T>>();
        var pendingToVisit = new ArrayDeque<>(List.of(from));
        var vertexAlreadyVisited = new HashSet<>();

        while (!pendingToVisit.isEmpty()) {

            var current = pendingToVisit.poll();
            if (vertexAlreadyVisited.contains(current)) {
                continue;
            }
            vertexAlreadyVisited.add(current);

            for (Entry<Vertex<T>, Integer> adjacent : current.adjacents().entrySet()) {
                var distanceFromOrigin = Optional.ofNullable(vertexPathTable.get(current))
                                                 .map(VertexTableEntry::totalDistance)
                                                 .orElse(0) + adjacent.getValue();
                vertexPathTable.putIfAbsent(adjacent.getKey(), new VertexTableEntry<>(current, distanceFromOrigin));
                if (vertexPathTable.get(adjacent.getKey()).totalDistance > distanceFromOrigin) {
                    vertexPathTable.put(adjacent.getKey(), new VertexTableEntry<>(current, distanceFromOrigin));
                }
            }
            pendingToVisit.addAll(current.adjacents().keySet());
        }
        return vertexPathTable;
    }


    public GraphPath<T> to(Vertex<T> to) {
        return new GraphPath<>(buildReversePath(from, to), shortestPathTable.get(to).totalDistance);
    }

    private List<T> buildReversePath(Vertex<T> from, Vertex<T> to) {
        var path = new ArrayList<T>(List.of(to.value()));
        var current = shortestPathTable.get(to);
        while (current.from != from) {
            path.add(current.from.value());
            current = shortestPathTable.get(current.from);
        }
        path.add(from.value());
        Collections.reverse(path);
        return path;
    }

    private record VertexTableEntry<T>(Vertex<T> from, Integer totalDistance) {

    }
}
