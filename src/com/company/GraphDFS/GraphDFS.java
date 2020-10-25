package com.company.GraphDFS;

import java.util.*;

public class GraphDFS {
    //Q-200 number of islands
    //initialize result = 0
    //For i,j in 2D matrix, if matrix[i][j]==1, call DFS(matrix, i, j)
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    private void DFS(char[][] grid, int i, int j){
        grid[i][j] = '0';
        for (int[] dir : dirs){
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0'){
                continue;
            }
            DFS(grid,x,y);
        }
    }
    public int numIslands(char[][] grid){
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == '1'){
                    count++;
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }
    //Q-332. Reconstruct Itinerary
    //Post-order traversal on Edges
    //建图，Adjacency Heap Map
    //Map{k,v}, v is a heap containing all cities connected by flight from city k
    public static List<String> findItinerary(List<List<String>> tickets){
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets){
            map.computeIfAbsent(ticket.get(0), k->new PriorityQueue<>()).offer(ticket.get(1));
        }

        List<String> res = new LinkedList<>();
        DFS332(res, map, "JFK");
        return res;
    }
    public static void DFS332(List<String> res, Map<String, PriorityQueue<String>> map, String cur){
        System.out.print("Current:"+cur+": ");

        PriorityQueue<String> neis = map.getOrDefault(cur, new PriorityQueue<>());
        while (!neis.isEmpty()){
            DFS332(res, map, neis.poll());
        }
        res.add(0,cur);
        System.out.println(res);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new LinkedList<>();
//        List<String> a = Arrays.asList("MUC", "LHR");
//        tickets.add(0,a);
        tickets.add(Arrays.asList("SUC", "SHR"));
        tickets.add(Arrays.asList("JFK", "SUC"));
        tickets.add(Arrays.asList("LFO", "MJC"));
        tickets.add(Arrays.asList("SHR", "LFO"));
        tickets.add(Arrays.asList("SUC", "LFO"));
        tickets.add(Arrays.asList("LFO","SUC"));

        List<List<String>> tickets2 = new LinkedList<>();
        tickets2.add(Arrays.asList("JFK","SFO"));
        tickets2.add(Arrays.asList("JFK","ATL"));
        tickets2.add(Arrays.asList("SFO","ATL"));
        tickets2.add(Arrays.asList("ATL","JFK"));
        tickets2.add(Arrays.asList("ATL","SFO"));

        System.out.println(findItinerary(tickets));
//        System.out.println(a);
        
    }
}
