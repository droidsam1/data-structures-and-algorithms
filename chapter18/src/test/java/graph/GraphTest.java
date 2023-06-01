package graph;

import static graph.Vertex.createVertex;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreOutputStream() {
        System.setOut(originalOut);
    }

    @Test
    void shouldVertexCanBeAddedToAGraph() {
        var aGraph = new Graph<String>();
        var aVertex = new Vertex<>("A label");

        aGraph.add(aVertex);

        assertNotNull(aGraph);
    }

    @Test
    void canBeEmpty() {
        var aGraph = new Graph<String>();
        assertTrue(aGraph.isEmpty());
    }

    @Test
    void canContainVertex() {
        var aGraph = new Graph<String>();
        var aVertex = new Vertex<>("A label");
        aGraph.add(aVertex);

        assertTrue(aGraph.contains(aVertex));
    }

    @Test
    void canConnectVertex() {
        var aGraph = new Graph<String>();
        var aVertex = new Vertex<>("A label");
        var anotherVertex = new Vertex<>("A different label");
        aVertex.connectWith(anotherVertex);

        aGraph.add(aVertex);

        assertTrue(aGraph.contains(aVertex));
        assertTrue(aGraph.contains(anotherVertex));
    }

    @Test
    void canSearchForDeeperConnections() {
        var aGraph = new Graph<String>();
        var drill = new Vertex<>("drill");
        var hammer = new Vertex<>("hammer");
        var saw = new Vertex<>("saw");
        var knife = new Vertex<>("knife");
        var fork = new Vertex<>("fork");
        drill.connectWith(hammer.connectWith(saw.connectWith(knife.connectWith(fork))));

        aGraph.add(drill);

        assertTrue(aGraph.contains(drill));
        assertTrue(aGraph.contains(saw));
        assertTrue(aGraph.contains(fork));
    }

    @Test
    void canSearchForAVertexEvenInCircularGraphs() {
        var aGraph = new Graph<String>();
        var drill = new Vertex<>("drill");
        var hammer = new Vertex<>("hammer");
        var saw = new Vertex<>("saw");
        var knife = new Vertex<>("knife");
        var fork = new Vertex<>("fork");
        drill.connectWith(hammer.connectWith(saw.connectWith(knife.connectWith(fork.connectWith(drill)))));

        aGraph.add(drill);

        assertTrue(aGraph.contains(fork));
    }

    @Test
    void breadFirstSearchShouldBehaveAsExample() {
        var aGraph = buildGraphFromExerciseThree();

        aGraph.traverseBfsAndPerform(vertex -> System.out.printf("%s", vertex.value()));

        assertEquals("abcdefghijklmnop", outContent.toString());
    }

    private Graph<String> buildGraphFromExerciseThree() {
        var aGraph = new Graph<String>();

        var a = createVertex("a");
        var b = createVertex("b");
        var c = createVertex("c");
        var d = createVertex("d");
        var e = createVertex("e");
        var f = createVertex("f");
        var g = createVertex("g");
        var h = createVertex("h");
        var i = createVertex("i");
        var j = createVertex("j");
        var k = createVertex("k");
        var l = createVertex("l");
        var m = createVertex("m");
        var n = createVertex("n");
        var o = createVertex("o");
        var p = createVertex("p");

        o.connectWith(j);
        j.connectWith(o);
        j.connectWith(f).connectWith(e);
        e.connectWith(j);
        f.connectWith(j);
        b.connectWith(e);
        b.connectWith(f);

        b.connectWith(a);
        a.connectWith(b);

        a.connectWith(c);
        c.connectWith(a);

        a.connectWith(d);
        d.connectWith(a);

        c.connectWith(a);
        c.connectWith(g);

        g.connectWith(c);
        g.connectWith(k);

        k.connectWith(g);

        d.connectWith(h);
        h.connectWith(d);
        h.connectWith(l);
        l.connectWith(h);
        h.connectWith(m);
        m.connectWith(h);
        m.connectWith(i);
        i.connectWith(m);
        i.connectWith(n);
        n.connectWith(i);
        n.connectWith(p);
        p.connectWith(n);

        d.connectWith(i);
        i.connectWith(d);

        aGraph.add(a);
        return aGraph;
    }

}
