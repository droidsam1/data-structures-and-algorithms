package fixture;

import static graph.Vertex.createVertex;

import graph.Graph;
import graph.Vertex;

public class GraphFixture {

    public static Graph<String> buildGraphFromExerciseThree() {
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


    public static Graph<String> aFriendshipGraphFromExerciseFive() {
        var aGraph = new Graph<String>();

        var idris = Vertex.createVertex("Idris");
        var kamil = Vertex.createVertex("Kamil");
        var talia = Vertex.createVertex("Talia");
        var lina = Vertex.createVertex("Lina");
        var ken = Vertex.createVertex("Ken");
        var marco = Vertex.createVertex("Marco");
        var sasha = Vertex.createVertex("Sasha");

        idris.connectWith(kamil);
        idris.connectWith(talia);

        kamil.connectWith(idris);
        kamil.connectWith(lina);

        lina.connectWith(kamil);
        lina.connectWith(sasha);

        talia.connectWith(idris);
        talia.connectWith(ken);

        ken.connectWith(talia);
        ken.connectWith(marco);

        marco.connectWith(ken);
        marco.connectWith(sasha);

        sasha.connectWith(marco);
        sasha.connectWith(lina);

        aGraph.add(idris);

        return aGraph;
    }
}
