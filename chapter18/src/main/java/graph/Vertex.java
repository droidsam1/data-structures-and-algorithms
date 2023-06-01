package graph;

import java.util.ArrayList;
import java.util.Objects;

public record Vertex<T>(T value, ArrayList<Vertex<T>> adjacentList) {

    public Vertex(T value) {
        this(value, new ArrayList<>());
    }

    public Vertex<T> connectWith(Vertex<T> newAdjacent) {
        adjacentList.add(newAdjacent);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vertex<?> vertex = (Vertex<?>) o;

        return Objects.equals(value, vertex.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Vertex{" + "value=" + value + '}';
    }
}
