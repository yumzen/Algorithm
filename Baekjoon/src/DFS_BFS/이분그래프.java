package DFS_BFS;

// 1707 이분 그래프
// https://www.acmicpc.net/problem/1707

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class 이분그래프 {

    public static boolean dfs(LinkedList<Integer>[] graph, String[] color, int start) {
        for (int next : graph[start]) {
            if (color[next] == null) {
                color[next] = color[start].equals("red") ? "blue" : "red";
                if (!dfs(graph, color, next)) {
                    return false;
                }
            } else if (color[next].equals(color[start])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        Integer K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++){
            String[] input = br.readLine().split(" ");
            Integer V = Integer.parseInt(input[0]);
            Integer E = Integer.parseInt(input[1]);

            LinkedList<Integer>[] graph = new LinkedList[V + 1];
            for (int j = 1; j <= V; j++) {
                graph[j] = new LinkedList<>();
            }
            String[] color = new String[V+1];

            for(int j=0; j<E ; j++){
                String[] point = br.readLine().split(" ");
                Integer a = Integer.parseInt(point[0]);
                Integer b = Integer.parseInt(point[1]);
                graph[a].add(b);
                graph[b].add(a);
            }

            boolean isBipartite = true;

            for (int j = 1; j <= V; j++) {
                if (color[j] == null) {
                    color[j] = "red";
                    if (!dfs(graph, color, j)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }
}
