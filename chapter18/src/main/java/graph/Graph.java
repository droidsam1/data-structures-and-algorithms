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
import java.util.stream.Collectors;

public class Graph<T> {

    private final Vertex<T> noConcreteValue = Vertex.createVertex(null);
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

    public boolean contains(Vertex<T> searchedVertex) {
        return breadthSearchFirst(searchedVertex, vertexSet.iterator().next(), v -> {
        }).isPresent();
    }

    private Optional<Vertex<T>> searchWithBfs(Vertex<T> searchedVertex) {
        return this.breadthSearchFirst(searchedVertex, vertexSet.iterator().next(), v -> {
        });
    }

    private Optional<Vertex<T>> breadthSearchFirst(
            Vertex<T> searchedVertex, Vertex<T> fromVertex, Consumer<Vertex<T>> vertexConsumer
    ) {
        Set<Vertex<T>> visitedVertex = new HashSet<>();
        Deque<Vertex<T>> neighbourhoodStack = new ArrayDeque<>();
        neighbourhoodStack.add(fromVertex);
        while (!neighbourhoodStack.isEmpty()) {
            var adjacent = neighbourhoodStack.pop();
            vertexConsumer.accept(adjacent);

            if (adjacent.value().equals(searchedVertex.value())) {
                return Optional.of(adjacent);
            }
            var visited = adjacent.adjacentList()
                                  .stream()
                                  .filter(not(neighbourhoodStack::contains))
                                  .collect(Collectors.partitioningBy(visitedVertex::contains));
            visitedVertex.add(adjacent);
            visitedVertex.addAll(visited.get(TRUE));
            neighbourhoodStack.addAll(visited.get(FALSE));

        }
        return Optional.empty();
    }

    public void traverseBfsAndPerform(Consumer<Vertex<T>> consumer) {
        this.breadthSearchFirst(noConcreteValue, vertexSet.iterator().next(), consumer);
    }

    public void traverseDfsAndPerform(Consumer<Vertex<T>> vertexConsumer) {
        this.traverseDfsAndPerform(vertexConsumer, vertexSet.iterator().next(), new HashSet<>());
    }

    public void traverseDfsAndPerform(Consumer<Vertex<T>> consumer, Vertex<T> vertex, Set<Vertex<T>> alreadyVisited) {
        if (alreadyVisited.contains(vertex)) {
            return;
        }
        alreadyVisited.add(vertex);
        consumer.accept(vertex);
        var pendingToVisit = vertex.adjacentList()
                                   .stream()
                                   .sorted(Comparator.comparing(o -> o.value().toString()))
                                   .toList();
        for (Vertex<T> adjacent : pendingToVisit) {
            traverseDfsAndPerform(consumer, adjacent, alreadyVisited);
        }
    }

    public GraphPath<T> findShortestPathBetween(Vertex<T> aVertex, Vertex<T> anotherVertex) {
        return searchWithBfs(aVertex).map(shortestPath(anotherVertex)).orElse(null);
    }

    private Function<Vertex<T>, GraphPath<T>> shortestPath(Vertex<T> anotherVertex) {
        return vertex -> DijkstraShortestPath.from(vertex).to(anotherVertex);
    }
}


