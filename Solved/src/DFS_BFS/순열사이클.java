package DFS_BFS;

import java.io.*;
import java.util.*;

public class 순열사이클 {
    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i) {
        if (visited[i]) return;

        visited[i] = true;

        for (int neighbor : adj.get(i)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] nums = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < N+1; i++) {
                adj.add(new ArrayList<>());
            }

            for(int i = 0; i< N; i++){
                adj.get(i+1).add(nums[i]);
            }

            boolean[] visited = new boolean[N+1];
            int count = 0;
            for(int i = 1; i<N+1; i++){
                if(!visited[i]){
                    dfs(adj, visited, i);
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
