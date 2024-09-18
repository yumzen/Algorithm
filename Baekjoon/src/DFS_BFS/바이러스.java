package DFS_BFS;

//2606 바이러스
//https://www.acmicpc.net/problem/2606

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 바이러스 {
    static int virusCount = 0;
    public static void dfs(LinkedList<Integer>[] graph, boolean[] visited, int start){
        visited[start] = true;

        for(int next:graph[start]){
            if(!visited[next]){
                virusCount++;
                dfs(graph, visited, next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        LinkedList<Integer>[] graph = new LinkedList[count + 1];

        for (int i = 1; i <= count; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < pair; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(graph, new boolean[count + 1],1);

        System.out.println(virusCount);
    }
}
