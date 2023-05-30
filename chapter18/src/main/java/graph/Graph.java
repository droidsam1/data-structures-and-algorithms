package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    private final Map<Vertex<T>, List<Vertex<T>>> adjacentsList;

    public Graph() {
        adjacentsList = new HashMap<>();
    }

    public void add(Vertex<T> aVertex) {
        adjacentsList.putIfAbsent(aVertex, new ArrayList<>());
    }
}
