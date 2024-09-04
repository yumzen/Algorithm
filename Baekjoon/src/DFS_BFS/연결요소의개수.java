package DFS_BFS;

//11724 연결 요소의 개수
//https://www.acmicpc.net/problem/11724

import java.util.Scanner;

public class 연결요소의개수 {

    public static void dfs(int[][] graph, boolean[] visited, int start) {
        visited[start] = true;

        for (int i = 1; i < graph.length; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        // 입력값을 받아온다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] graph = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];
        int count = 0;

        // 인접행렬을 만든다.
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // DFS를 통해 연결요소의 개수를 구한다.
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }

        System.out.println(count);
    }
}
