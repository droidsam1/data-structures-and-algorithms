package graph;

import java.util.ArrayList;

public record Vertex<T>(T value, ArrayList<Vertex<T>> adjacentList) {

    public Vertex(T value) {
        this(value, new ArrayList<>());
    }

    public Vertex<T> connectWith(Vertex<T> newAdjacent) {
        adjacentList.add(newAdjacent);
        return this;
    }

}
