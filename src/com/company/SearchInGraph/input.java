package com.company.SearchInGraph;

import com.company.GraphDFS.Algos;
import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class input {
    public List<String> readFile(String s){
        List<String> input = new LinkedList<>();
        try {
            FileReader fr = new FileReader(s);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while (true) {
                if (!((str = bf.readLine()) != null)) break;
                input.add(str);
            }
            bf.close();
            fr.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return input;
    }
    public List<List<String>> toList(List<String> strings){
        List<List<String>> s = new ArrayList<>();
        for (String str : strings){
            s.add(Arrays.asList(str .split(" ")));
        }
        return s;
    }
    public Map<String,Map<String,Integer>> constructGraph(List<List<String>> ss){
        Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
        for (List<String> s : ss){
            String node1 = s.get(0);
            String node2 = s.get(1);
            Integer weight = Integer.valueOf(s.get(2));
            map.computeIfAbsent(node1,k -> new HashMap<String,Integer>()).put(node2,weight);
        }
        for (List<String> s : ss){
            String node1 = s.get(1);
            String node2 = s.get(0);
            Integer weight = Integer.valueOf(s.get(2));
            map.computeIfAbsent(node1,k -> new HashMap<String,Integer>()).put(node2,weight);
        }
        return map;
    }
    public boolean isConnected(String node1, String node2, Map<String,Map<String,Integer>> map) {
        Map<String, Integer> adjacent = map.get(node1);
        if(adjacent==null) {
            return false;
        }
        return adjacent.containsKey(node2);
    }
    public Map<String, Integer> adjacentNodes(String node, Map<String,Map<String,Integer>> map) {
        Map<String, Integer> adjacent = map.get(node);
        if(adjacent==null) {
            return new HashMap<String, Integer>();
        }
        return new HashMap<String, Integer>(adjacent);
    }

    public static void main(String[] args) {
        input input = new input();
        Algos BFS = new Algos();
        List<String> inputlist = input.readFile("C:\\Users\\MTX\\Documents\\GitHub\\LeetCodeTest\\src\\com\\company\\SearchInGraph\\input");
        List<List<String>> ss = input.toList(inputlist);
        Map<String,Map<String,Integer>> graph = input.constructGraph(ss);
        LinkedList<String> path = BFS.BFShortestPath("Казань","Таллинн",graph);
        for (String s : path){
            System.out.println(s);
        }
    }

}
