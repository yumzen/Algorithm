package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 스타트와링크 {

    public static int calculateDifference(int[][] arr, boolean[] visited, int N) {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startSum += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkSum += arr[i][j] + arr[j][i];
                }
            }
        }

        return Math.abs(startSum - linkSum);
    }

    public static int dfs(int N, int[][] arr, boolean[] visited, int depth, int index, int min) {
        if (depth == N / 2) {
            int diff = calculateDifference(arr, visited, N);
            return Math.min(min, diff);
        }

        for (int i = index; i < N; i++) {
            visited[i] = true;
            min = dfs(N, arr, visited, depth + 1, i + 1, min);
            visited[i] = false;
        }

        return min;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        boolean[] visited = new boolean[N];
        int min = dfs(N, arr, visited, 0, 0, Integer.MAX_VALUE);
        System.out.println(min);
    }
}