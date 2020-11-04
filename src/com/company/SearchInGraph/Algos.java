package com.company.SearchInGraph;

import com.company.DFS.DFS;

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
    //DFS for route
    Stack<String> stack = new Stack<>();
    List<String> visited = new LinkedList<>();
    Map<String,String> paths = new HashMap<>();
    public void DFS(String cur, String end, Map<String,Map<String,Integer>> g){

        stack.push(cur);
        visited.add(cur);
        Set<String> neis = g.get(cur).keySet();

        for (String nei : neis){
            if (!visited.contains(nei)){
                paths.put(nei,cur);
                DFS(nei, end, g);
            }
        }



    }

    public void testpath(String begin, String end, Map<String,Map<String,Integer>> g){
        DFS(begin, end, g);
        System.out.println(paths.keySet());
    }
    public LinkedList<String> getpath(String begin, String end, Map<String,Map<String,Integer>> g){
        DFS(begin, end, g);
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

    public static void main(String[] args) {
        input input = new input();
        Algos algos = new Algos();
        List<String> inputlist = input.readFile("C:\\Users\\MTX\\Documents\\GitHub\\LeetCodeTest\\src\\com\\company\\SearchInGraph\\input");
        List<List<String>> ss = input.toList(inputlist);
        Map<String,Map<String,Integer>> graph = input.constructGraph(ss);
//        algos.testpath("Казань","Таллинн",graph);
        LinkedList<String> path = algos.getpath("Казань","Таллинн",graph);
        for (String s : path){
            System.out.println(s);
        }
    }
}
