package com.company.BestFirstSearch;

import java.util.*;

public class BestFirstSearch {
    //Q-743 Network Delay Time
    //计算由初始节点到最远的节点的最短路径
    //创建 Adjacency List Map
    //For each edge (src, dst, cost)
    //  a. map[src] = {dst, cost}
    class Cell implements Comparable<Cell>{
        int node, time;
        Cell(int node, int time){
            this.node = node;
            this.time = time;
        }
        public int compareTo(Cell c2){
            return time-c2.time;
        }
    }
    public int networkDelayTime(int[][] times, int N, int K){
        //初始化
        Map<Integer, List<Cell>> map = new HashMap<>();
        for (int[] time : times){
            List<Cell> edges = map.getOrDefault(time[0], new ArrayList<>());
            edges.add(new Cell(time[1], time[2]));
            map.put(time[0], edges);
        }

        //HashMap记录cost
        Map<Integer,Integer> costs = new HashMap<>();
        PriorityQueue<Cell> heap = new PriorityQueue<>();
        heap.offer(new Cell(K,0));

        while (!heap.isEmpty()){
            Cell cur = heap.poll();
            if (costs.containsKey(cur.node))
                continue;//若存在则跳过
            costs.put(cur.node, cur.time); //记录visited
            if (map.containsKey(cur.node)){
                for (Cell nei: map.get(cur.node)){ //提取所有邻接点
                    if (!costs.containsKey(nei.node)){ //若未访问过,存入堆并记录新的cost
                        heap.offer(new Cell(nei.node, cur.time + nei.time));
                    }
                }
            }
        }
        if (costs.size() != N){
            return -1;
        }
        int res = 0;
        for (int x: costs.values())
            res = Math.max(res,x);
        return res;

    }

    //Q-787 Cheapest Flights Within k Stops
    //多存一个信息{node,cost,stop}
    //初始化
    public int CheapestFlightsWithinKStops(int[][] flights, int src, int dst, int K){
        class Cell implements Comparable<Cell>{
            int dst, stop, price;
            Cell(int dst, int stop, int price){
                this.dst = dst;
                this.stop = stop;
                this.price = price;
            }
            public int compareTo(Cell other){
                return price - other.price;
            }
        }
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights){
            List<int[]> to = map.getOrDefault(flight[0], new ArrayList<>());
            to.add(new int[]{flight[1], flight[2]});
            map.put(flight[0],to);
        }

        PriorityQueue<Cell> heap = new PriorityQueue<>();
        heap.offer(new Cell(src, K, 0));

        while (!heap.isEmpty()){
            Cell cur = heap.poll();
            if (cur.dst==dst){
                return cur.price;
            }
            if (cur.stop >= 0 && map.containsKey(cur.dst)){
                for (int[] next : map.get(cur.dst)){
                    heap.offer(new Cell(next[0], cur.stop - 1, cur.price + next[1]));
                }
            }
        }
        return -1;

    }
}
