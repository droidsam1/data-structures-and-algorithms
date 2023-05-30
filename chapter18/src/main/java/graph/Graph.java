package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    private final Map<Vertex<T>, List<Vertex<T>>> adjacentList;

    public Graph() {
        adjacentList = new HashMap<>();
    }

    public void add(Vertex<T> aVertex) {
        adjacentList.putIfAbsent(aVertex, new ArrayList<>());
    }

    public boolean isEmpty() {
        return this.adjacentList.isEmpty();
    }

    public boolean contains(Vertex<T> aVertex) {
        return this.adjacentList.containsKey(aVertex);
    }
}
