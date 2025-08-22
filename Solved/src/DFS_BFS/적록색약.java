package DFS_BFS;

import java.io.*;

public class 적록색약 {
    public static void dfs(String[][] arr, boolean[][] visited, int x, int y, String color) {
        int n = arr.length;
        if (x < 0 || y < 0 || x >= n || y >= n) return;      // 범위 밖
        if (visited[x][y]) return;                           // 이미 방문
        if (!arr[x][y].equals(color)) return;                // 색 다르면 pass

        visited[x][y] = true;

        dfs(arr, visited, x + 1, y, color);
        dfs(arr, visited, x - 1, y, color);
        dfs(arr, visited, x, y + 1, color);
        dfs(arr, visited, x, y - 1, color);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][N];
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine().split("");
        }

        int normalCount = 0;
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(arr, visited, i, j, arr[i][j]);
                    normalCount++;
                }
            }
        }

        String[][] colorWeakArr = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j].equals("G")) colorWeakArr[i][j] = "R";
                else colorWeakArr[i][j] = arr[i][j];
            }
        }

        int colorWeakCount = 0;
        visited = new boolean[N][N]; // 방문 배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(colorWeakArr, visited, i, j, colorWeakArr[i][j]);
                    colorWeakCount++;
                }
            }
        }

        System.out.println(normalCount + " " + colorWeakCount);
    }
}