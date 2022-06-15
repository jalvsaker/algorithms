package org.pg4200.exam;

import org.junit.jupiter.api.Test;

public class Ex02Test {

    Ex02<Integer> setup(){
        Ex02<Integer> graph= new Ex02<>();

        graph.addEdgeMetro(1,2);
        graph.addEdgeMetro(2,3);
        graph.addEdgeMetro(1,4);
        graph.addEdgeMetro(3,7);
        graph.addEdgeMetro(4,8);
        graph.addEdgeMetro(7,9);
        graph.addEdgeMetro(8,10);
        graph.addEdgeMetro(9,10);

        graph.addEdgeTram(1, 5);
        graph.addEdgeTram(2, 5);
        graph.addEdgeTram(2,6);
        graph.addEdgeTram(3,6);
        graph.addEdgeTram(4,5);
        graph.addEdgeTram(5,6);
        graph.addEdgeTram(7,6);
        graph.addEdgeTram(5,8);
        graph.addEdgeTram(5,10);
        graph.addEdgeTram(6,10);

        return graph;
    }

    @Test
    void test(){
        var graph = setup();

        var path = graph.findPath(5, 9);

        if (path == null) {
            System.out.println("no path");
            return;
        }

        for (int i: path) {
            System.out.println(i);
        }

    }

    @Test
    void test2(){
        var graph = setup();

        System.out.println(graph.getNumberOfEdges());
        System.out.println(graph.getNumberOfVertices());

        graph.removeEdgeMetro(1,2);


        System.out.println();
        System.out.println(graph.getNumberOfEdges());
        System.out.println(graph.getNumberOfVertices());

        graph.removeVertex(5);
        System.out.println();
        System.out.println(graph.getNumberOfEdges());
        System.out.println(graph.getNumberOfVertices());
    }
}
