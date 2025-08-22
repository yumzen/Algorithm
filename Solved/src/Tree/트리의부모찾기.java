package Tree;

import java.io.*;
import java.util.*;

public class 트리의부모찾기 {
    public static void dfs(int cur, int p, int[] parent, List<List<Integer>> graph){
        parent[cur] = p;
        for(int next: graph.get(cur)){
            if(next != p) dfs(next, cur, parent, graph);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i =0; i<N-1; i++){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] parent = new int[N+1];
        dfs(1, 0, parent, graph);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
}
