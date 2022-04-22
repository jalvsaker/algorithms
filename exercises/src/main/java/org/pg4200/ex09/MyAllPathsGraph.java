package org.pg4200.ex09;

import org.pg4200.les09.UndirectedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyAllPathsGraph<V> extends UndirectedGraph<V> {

    public List<List<V>> findAllPaths(V start, V end){

        if (!graph.containsKey(start) || !graph.containsKey(end)){
            return new ArrayList<>();
        }

        if (start.equals(end)){
            return null;
        }

        Stack<V> stack = new Stack<>();
        List<List<V>> paths = new ArrayList<>();

        findAllPathsDF(stack, paths, start, end);

        return paths;
    }

    private void findAllPathsDF(Stack<V> stack, List<List<V>> paths, V current, V end){

        stack.push(current);

        if (current.equals(end)){
            List<V> path = new ArrayList<>(stack);
            paths.add(path);
            stack.pop();
            return;
        }

        List<V> connected = new ArrayList<>();

        for (V node : graph.get(current)){
            if (!stack.contains(node)){
                connected.add(node);
            }
        }

        while (!connected.isEmpty()){
            V next = connected.iterator().next();
            connected.remove(next);
            findAllPathsDF(stack, paths, next, end);
        }

        stack.pop();
    }

}
