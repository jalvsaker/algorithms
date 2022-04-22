package org.pg4200.ex09;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAllPathsGraphTest {
    @Test
    void testStuff(){
        MyAllPathsGraph<String> graph = new MyAllPathsGraph<>();

        assertEquals(0, graph.getNumberOfVertices());

        graph.addEdge("0","X");
        graph.addEdge("X","1");
        graph.addEdge("X","Y");
        graph.addEdge("1","2");
        graph.addEdge("2","Y");
        graph.addEdge("1","3");
        graph.addEdge("3","4");
        graph.addEdge("3","5");
        graph.addEdge("4","5");

        List<List<String>> allPaths = graph.findAllPaths("X", "5");

        assertNotNull(allPaths);
        assertEquals(4, allPaths.size());

        List<String> testPath = new ArrayList<>();
        testPath.add(0, "X");
        testPath.add(1, "1");
        testPath.add(2, "3");
        testPath.add(3, "5");

        assertTrue(allPaths.contains(testPath));

        assertTrue(allPaths.stream().allMatch(p -> p.get(0).equals("X")));
    }
}
