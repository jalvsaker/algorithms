package org.pg4200.exam;

import org.pg4200.les09.UndirectedGraph;

import java.util.*;

public class Ex02<V> {

    UndirectedGraph<V> metro = new UndirectedGraph<>();
    UndirectedGraph<V> tram = new UndirectedGraph<>();
    HashSet<V> vertices = new HashSet<>();

    /*
    Finds path between nodes using BFS algorithm
     */
    public List<V> findPath(V start, V end){
        if (!vertices.contains(start)||!vertices.contains(end)){
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

        Queue<V> queue = new ArrayDeque<>();
        Map<V, V> bestParent = new HashMap<>();

        queue.add(start);

        loop: while (!queue.isEmpty()){
            V parent = queue.poll();

            for (V child: getAdjacents(parent)){
                if(child.equals(start)||bestParent.get(child) != null){
                    continue;
                }
                bestParent.put(child, parent);

                if (child.equals(end)){
                    break loop;
                }

                queue.add(child);
            }


        }
        if(!bestParent.containsKey(end)){
            return null;
        }

        List<V> path = new ArrayList<>();
        V current = end;
        while (current != null){
            path.add(0,current);
            current = bestParent.get(current);
        }

        return path;
    }

    public Collection<V> getAdjacents(V vertex) {
        Collection<V> adjacents = metro.getAdjacents(vertex);
        adjacents.addAll(tram.getAdjacents(vertex));
        return adjacents;
    }
    public void addVertex(V vertex){
        metro.addVertex(vertex);
        tram.addVertex(vertex);
        vertices.add(vertex);
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

    public int getNumberOfVertices() {
        return vertices.size();
    }

    public int getNumberOfEdges(){
        return metro.getNumberOfEdges() + tram.getNumberOfEdges();
    }

    public void removeEdgeTram(V from, V to){
        tram.removeEdge(from,to);
    }
    public void removeEdgeMetro(V from, V to){
        metro.removeEdge(from, to);
    }

    public void removeVertex(V vertex){

        if (!vertices.contains(vertex)){
            return;
        }

        metro.removeVertex(vertex);
        tram.removeVertex(vertex);
        vertices.remove(vertex);
    }
}
