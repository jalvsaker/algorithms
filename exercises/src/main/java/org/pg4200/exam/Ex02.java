package org.pg4200.exam;

import org.pg4200.les09.UndirectedGraph;

import java.util.*;

public class Ex02<V> {

    UndirectedGraph<V> metro = new UndirectedGraph<>();
    UndirectedGraph<V> tram = new UndirectedGraph<>();
    HashSet<V> vertexes = new HashSet<>();

    /*
    Finds path between nodes
     */
    public List<V> findPath(V start, V end){
        if (!vertexes.contains(start)||!vertexes.contains(end)){
            return null;
        }


        List<V> metroPath = metro.findPathBFS(start, end);
        List<V> tramPath = tram.findPathBFS(start, end);

        if (metroPath != null && tramPath != null){
            if (metroPath.size() <= tramPath.size()){
                return metroPath;
            }
            return tramPath;
        } else if (metroPath != null){
            return metroPath;
        } else if (tramPath != null){
            return tramPath;
        }

        Set<V> alreadyVisited = new HashSet<>();
        Deque<V> stack = new ArrayDeque<>();

        dfs(alreadyVisited, stack, start, end);

        if (isPathTo(stack, end)){
            List<V> path = new ArrayList<>(stack);
            Collections.reverse(path);
            return path;
        }

        System.out.println();
        return null;
    }

    private void dfs(Set<V> alreadyVisited, Deque<V> stack, V current, V end){
        alreadyVisited.add(current);
        stack.push(current);

        if(isPathTo(stack, end)){
            return;
        }

        for (V connected : getAdjacents(current)){
            if (alreadyVisited.contains(connected)){
                continue;
            }

            dfs(alreadyVisited, stack, connected, end);

            if(! isPathTo(stack, end)){
                stack.pop();
            } else {
                return;
            }
        }
    }

    public Collection<V> getAdjacents(V vertex) {
        Collection<V> adjacents = metro.getAdjacents(vertex);
        adjacents.addAll(tram.getAdjacents(vertex));
        return adjacents;
    }

    private boolean isPathTo(Deque<V> stack, V vertex){
        return !stack.isEmpty() && stack.peek().equals(vertex);
    }

    public void addVertex(V vertex){
        metro.addVertex(vertex);
        tram.addVertex(vertex);
        vertexes.add(vertex);
    }

    public void addEdgeTram(V from, V to){
        //make sure it's in both
        addVertex(from);
        addVertex(to);

        tram.addEdge(from, to);
    }

    public void addEdgeMetro(V from, V to){
        addVertex(from);
        addVertex(to);

        metro.addEdge(from, to);
    }
}
