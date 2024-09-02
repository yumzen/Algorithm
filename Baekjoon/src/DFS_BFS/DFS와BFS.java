package DFS_BFS;

// 1260 DFS와 BFS
// https://www.acmicpc.net/problem/1260

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class DFS와BFS {

    static LinkedList<Integer>[] graph = new LinkedList[1001];
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int start) {
        visited[start] = true;  // 현재 노드를 방문 처리
        sb.append(start).append(" ");  // 방문한 노드를 결과에 추가

        for (int next : graph[start]) {  // 현재 노드의 인접 노드를 탐색
            if (!visited[next]) {  // 방문하지 않은 노드가 있으면 DFS로 탐색
                dfs(next);
            }
        }
    }

    public static void bfs(int start){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;  // 시작 정점을 방문 처리
        queue.add(start);  // 시작 정점을 큐에 추가

        while (!queue.isEmpty()) {
            int current = queue.poll();  // 큐에서 정점을 꺼내서 처리
            sb.append(current).append(" ");  // 방문한 노드를 결과에 추가

            for (int next : graph[current]) {  // 현재 노드의 인접 노드를 탐색
                if (!visited[next]) {  // 방문하지 않은 노드가 있으면 큐에 추가하고 방문 처리
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);

        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        //입력으로 주어지는 간선은 양방향이다.라는 문제 조건을 고려하였다.
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        //방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문한다.라는 문제 조건을 고려하여 graph[i]에 저장된 정점들을 오름차순으로 정렬한다.
        for(int i=1; i<=N; i++){
            graph[i].sort(null);
        }

        // DFS
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        // BFS
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }
}
