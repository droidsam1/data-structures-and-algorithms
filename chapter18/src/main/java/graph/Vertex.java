package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public record Vertex<T>(T value, Map<Vertex<T>, Integer> adjacents) {

    public Vertex(T value) {
        this(value, new HashMap<>());
    }

    public static <T> Vertex<T> createVertex(T value) {
        return new Vertex<>(value);
    }

    public Vertex<T> connectWith(Vertex<T> newAdjacent) {
        return connectWith(newAdjacent, 1);
    }

    public Vertex<T> connectWith(Vertex<T> newAdjacent, int weight) {
        adjacents.put(newAdjacent, weight);
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
