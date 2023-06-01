package graph;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph<T> {

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
        Optional<Vertex<T>> foundedVertex = Optional.empty();
        for (Vertex<T> aVertex : vertexMap) {
            if (aVertex.value().equals(searchedVertex.value())) {
                return true;
            } else {
                foundedVertex = breadSearchFirst(searchedVertex, aVertex);
            }
        }
        return foundedVertex.isPresent();
    }

    private Optional<Vertex<T>> breadSearchFirst(Vertex<T> searchedVertex, Vertex<T> fromVertex) {
        Set<Vertex<T>> visitedVertex = new HashSet<>();
        Deque<Vertex<T>> neighbourhoodStack = new ArrayDeque<>();
        neighbourhoodStack.add(fromVertex);
        while (!neighbourhoodStack.isEmpty()) {
            var adjacent = neighbourhoodStack.pop();
            if (adjacent.value().equals(searchedVertex.value())) {
                return Optional.of(adjacent);
            }
            var visited = adjacent.adjacentList().stream().collect(Collectors.partitioningBy(visitedVertex::contains));
            visitedVertex.add(adjacent);
            visitedVertex.addAll(visited.get(TRUE));
            neighbourhoodStack.addAll(visited.get(FALSE));
        }
        return Optional.empty();
    }

}
