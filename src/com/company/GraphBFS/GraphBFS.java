package com.company.GraphBFS;

import java.util.*;

public class GraphBFS {
    //Q-542 Matrix O(mn)
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

    public int[][] updateMatrix(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int cost = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int s = 0; s < size; s++){
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1];
                if (matrix[i][j] == 1){
                    res[i][j] = cost;
                }

                for (int[] dir : dirs){
                    int x = i + dir[0], y = j + dir[1];
                    if (0 <= x && x < m && 0 <= y && y < n && !visited[x][y]){
                        queue.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            cost++;
        }
        return res;
    }

    //Q-127 Word ladder
    private Map<String, List<String>> constructGraph(List<String> wordList){
        Map<String,List<String>> graph = new HashMap<>();
        int n = wordList.size();
        for (int i = 0; i< n-1; i++){
            for (int j = i + 1; j < n; j++){
                String w1 = wordList.get(i), w2 = wordList.get(j);
                if (oneChangeAway(w1, w2)){
                    graph.computeIfAbsent(w1, k-> new ArrayList<>()).add(w2);
                    graph.computeIfAbsent(w2, k-> new ArrayList<>()).add(w1);

                }
            }
        }
        return graph;
    }

    private boolean oneChangeAway(String w1, String w2){
        int diff = 0;
        for (int i = 0; i < w1.length(); i++){
            char c1 = w1.charAt(i), c2 = w2.charAt(i);
            if (c1 != c2){
                diff++;
            }
        }
        return diff == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        if (!wordList.contains(endWord)){
            return 0;
        }
        if (!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }

        Map<String, List<String>> graph = constructGraph(wordList);

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.add(beginWord);

        int cost = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i ++){
                String cur = queue.poll();
                if (cur.equals(endWord)){
                    return cost;
                }

                for (String neighbor : graph.getOrDefault(cur, new ArrayList<>())){
                    if (!visited.contains(neighbor)){
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            cost++;
        }

        return 0;
    }


}
