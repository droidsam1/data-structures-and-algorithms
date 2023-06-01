package graph;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.function.Predicate.not;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Graph<T> {
    private final Vertex<T> noConcreteValue = Vertex.createVertex(null);
    private final Set<Vertex<T>> vertexMap;

    public Graph() {
        vertexMap = new HashSet<>();
    }

    public void add(Vertex<T> aVertex) {
        vertexMap.add(aVertex);
    }

    public boolean isEmpty() {
        return vertexMap.isEmpty();
    }

    public boolean contains(Vertex<T> searchedVertex) {
        return breadSearchFirst(searchedVertex, vertexMap.iterator().next(),  v -> {}).isPresent();
    }

    private void breadSearchFirst(Consumer<Vertex<T>> operatorToPerformOnEveryVertex) {
        this.breadSearchFirst(noConcreteValue, vertexMap.iterator().next(), operatorToPerformOnEveryVertex);
    }

    private Optional<Vertex<T>> breadSearchFirst(
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
        breadSearchFirst(consumer);
    }
}
