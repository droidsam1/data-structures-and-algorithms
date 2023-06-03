package fixture;

import static graph.Vertex.createVertex;

import graph.Graph;

public class GraphFixture {

    public static Graph<String> buildGraphFromExerciseOne() {
        var aGraph = new Graph<String>();
        var drill = createVertex("drill");
        var hammer = createVertex("hammer");
        var saw = createVertex("saw");
        var knife = createVertex("knife");
        var fork = createVertex("fork");
        var spoon = createVertex("spoon");
        drill.connectWith(hammer.connectWith(saw.connectWith(knife.connectWith(fork).connectWith(spoon))));

        var brush = createVertex("brush");
        var nailPolish = createVertex("nail polish");
        var eyeShadow = createVertex("eye shadow");
        var eyeGlasses = createVertex("eye glasses");
        brush.connectWith(nailPolish.connectWith(eyeShadow.connectWith(eyeGlasses)));

        var nails = createVertex("nails");
        var pins = createVertex("pins");
        var needles = createVertex("needles");
        nails.connectWith(pins.connectWith(needles)).connectWith(needles).connectWith(nailPolish).connectWith(hammer);

        aGraph.add(drill);

        return aGraph;
    }

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

        var idris = createVertex("Idris");
        var kamil = createVertex("Kamil");
        var talia = createVertex("Talia");
        var lina = createVertex("Lina");
        var ken = createVertex("Ken");
        var marco = createVertex("Marco");
        var sasha = createVertex("Sasha");

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

    public static Graph<String> buildFlightMapFromPage376() {
        var aGraph = new Graph<String>();
        var chicago = createVertex("Chicago");
        var denver = createVertex("Denver");
        var boston = createVertex("Boston");
        var elPaso = createVertex("El Paso");
        var atlanta = createVertex("Atlanta");

        elPaso.connectWith(boston, 100);

        denver.connectWith(elPaso, 140);
        denver.connectWith(chicago, 40);

        chicago.connectWith(elPaso, 80);

        boston.connectWith(denver, 180);
        boston.connectWith(chicago, 120);

        atlanta.connectWith(boston, 100);
        atlanta.connectWith(denver, 160);

        aGraph.add(atlanta);


        return aGraph;
    }
}
