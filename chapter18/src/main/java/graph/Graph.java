package graph;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.function.Predicate.not;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Graph<T> {

    private final Vertex<T> noConcreteValue = Vertex.createVertex(null);
    private final Set<Vertex<T>> vertexSet;
    private final Map<Vertex<T>, PathVertex<T>> pathMap = new HashMap<>();

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

    private void breadthSearchFirst(Consumer<Vertex<T>> operatorToPerformOnEveryVertex) {
        this.breadthSearchFirst(noConcreteValue, vertexSet.iterator().next(), operatorToPerformOnEveryVertex);
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
        breadthSearchFirst(consumer);
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
        buildPathMap();
        List<T> result = new ArrayList<>();
        if (pathMap.get(anotherVertex) == null) {
            return null;
        }
        var current = pathMap.get(anotherVertex);
        result.add(anotherVertex.value());
        while (current != null && !current.from.equals(aVertex)) {
            result.add(current.from().value());
            current = pathMap.get(current.from);
        }
        result.add(aVertex.value());
        Collections.reverse(result);
        return new GraphPath<>(result, pathMap.get(anotherVertex).distance);
    }

    private void buildPathMap() {
        Set<Vertex<T>> visitedVertex = new HashSet<>();
        Deque<Vertex<T>> neighbourhoodStack = new ArrayDeque<>();
        neighbourhoodStack.add(vertexSet.iterator().next());
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

    void processVertex(Vertex<T> current, Set<Vertex<T>> visitedVertex, int accumulatedDistance) {
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


