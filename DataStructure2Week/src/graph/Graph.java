package graph;

import java.util.*;

public class Graph {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public boolean addVertex(int vertex){
        if (map.get(vertex) == null) {
            map.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(int vertex1, int vertex2){
        if (!map.containsKey(vertex1)){
            addVertex(vertex1);
        }
        if (!map.containsKey(vertex2)){
            addVertex(vertex2);
        }
        map.get(vertex1).add(vertex2);
        map.get(vertex2).add(vertex1);
        return true;
    }

    public boolean removeEdge(int vertex1, int vertex2){
        if (map.get(vertex1) != null && map.get(vertex2) != null){
            map.get(vertex1).remove(vertex2);
            map.get(vertex2).remove(vertex1);
            return true;
        }
         return false;
    }

    public boolean removeVertex(int vertex){
        if (map.get(vertex) == null) return false;
        for (int otherVertex : map.get(vertex)) {
            map.get(otherVertex).remove(vertex);

        }
        map.remove(vertex);
        return true;
    }
    public void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current+" ");

            for (int connections : map.get(current)){
                if (!visited.contains(connections)){
                    visited.add(connections);
                    queue.offer(connections);
                }
            }
            System.out.println();
        }
    }
    public void display(){
        for(int x : map.keySet()){
            System.out.print(x+ ": ");
            for(int y : map.get(x)){
                System.out.print(y+ " ");
            }
            System.out.println();
        }
    }
}





