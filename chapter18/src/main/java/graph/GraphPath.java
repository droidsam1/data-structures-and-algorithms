package graph;

import java.util.List;

public record GraphPath<T>(List<T> path, int distance) {

}
