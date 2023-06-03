package graph;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.function.Predicate.not;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Graph<T> {

    private final Set<Vertex<T>> vertexSet;

    public Graph() {
        vertexSet = new HashSet<>();
    }

    public void add(Vertex<T> aVertex) {
        vertexSet.add(aVertex);
    }

    public boolean isEmpty() {
        return vertexSet.isEmpty();
    }

    public boolean contains(T searchedVertex) {
        return searchWithBfs(searchedVertex).isPresent();
    }

    private Optional<Vertex<T>> searchWithBfs(T searchedVertex) {
        for (Vertex<T> tVertex : vertexSet) {
            var foundIt = this.breadthSearchFirst(searchedVertex, tVertex, v -> {
            });
            if (foundIt.isPresent()) {
                return foundIt;
            }
        }
        return Optional.empty();
    }

    private Optional<Vertex<T>> breadthSearchFirst(
            T searchedVertex, Vertex<T> fromVertex, Consumer<T> vertexConsumer
    ) {
        Set<Vertex<T>> visitedVertex = new HashSet<>();
        Deque<Vertex<T>> neighbourhoodStack = new ArrayDeque<>();
        neighbourhoodStack.add(fromVertex);
        while (!neighbourhoodStack.isEmpty()) {
            var adjacent = neighbourhoodStack.pop();
            vertexConsumer.accept(adjacent.value());

            if (adjacent.value().equals(searchedVertex)) {
                return Optional.of(adjacent);
            }
            var visited = adjacent.adjacents()
                                  .keySet()
                                  .stream()
                                  .filter(not(neighbourhoodStack::contains))
                                  .collect(Collectors.partitioningBy(visitedVertex::contains));
            visitedVertex.add(adjacent);
            visitedVertex.addAll(visited.get(TRUE));
            neighbourhoodStack.addAll(visited.get(FALSE));

        }
        return Optional.empty();
    }

    public void traverseBfsAndPerform(Consumer<T> consumer) {
        vertexSet.forEach(vertex -> this.breadthSearchFirst(null, vertex, consumer));
    }

    public void traverseDfsAndPerform(Consumer<T> vertexConsumer) {
        vertexSet.forEach(vertex -> this.traverseDfsAndPerform(vertex, new HashSet<>(), vertexConsumer));
    }

    public void traverseDfsAndPerform(Vertex<T> vertex, Set<Vertex<T>> alreadyVisited, Consumer<T> consumer) {
        if (alreadyVisited.contains(vertex)) {
            return;
        }
        alreadyVisited.add(vertex);
        consumer.accept(vertex.value());
        var pendingToVisit = vertex.adjacents()
                                   .keySet()
                                   .stream()
                                   .sorted(Comparator.comparing(o -> o.value().toString()))
                                   .toList();
        for (Vertex<T> adjacent : pendingToVisit) {
            traverseDfsAndPerform(adjacent, alreadyVisited, consumer);
        }
    }

    public GraphPath<T> findShortestPathBetween(T aVertex, T anotherVertex) {
        return searchWithBfs(aVertex).map(shortestPath(anotherVertex)).orElseThrow(originVertexNotFound());
    }

    private Supplier<IllegalArgumentException> originVertexNotFound() {
        return () -> new IllegalArgumentException("Origin vertex is not present in the graph");
    }

    private Function<Vertex<T>, GraphPath<T>> shortestPath(T anotherVertex) {
        return vertex -> ShortestPathDijkstra.from(vertex).to(Vertex.createVertex(anotherVertex));
    }
}


