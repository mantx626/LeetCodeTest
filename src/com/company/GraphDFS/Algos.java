package com.company.GraphDFS;

import com.company.Stack.Stack;

import java.util.*;

public class Algos {
    public LinkedList<String> BFShortestPath(String begin, String end, Map<String,Map<String,Integer>> g){

        Map<String,Map<String,Integer>> graph = g;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Map<String,String> paths = new HashMap<>();
        visited.add(begin);
        queue.add(begin);

        while (!queue.isEmpty()){
            String ver = queue.poll();

            Set<String> toBeVisitedVertex = g.get(ver).keySet();
            for (String v : toBeVisitedVertex) {
                if (false == visited.contains(v)) {
                    visited.add(v);
                    paths.put(v, ver);
                    queue.add(v);
                }
            }
        }

        LinkedList<String> path = new LinkedList<>();
        path.add(end);
//        System.out.println(paths.containsKey("Таллин"));
//        System.out.println(paths.keySet());
        for (String location = paths.get(end) ; false == location.equals(begin) ; location = paths.get(location)) {
            path.add(0,location);
        }
        path.add(0,begin);
        return path;
    }
}
