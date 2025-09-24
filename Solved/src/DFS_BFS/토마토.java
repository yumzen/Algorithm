package DFS_BFS;

import java.io.*;
import java.util.*;

public class 토마토 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Integer M = Integer.parseInt(input[0]);
        Integer N = Integer.parseInt(input[1]);


        int[][] box = new int[M][N];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i <N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j<M; j++){
                box[j][i] = Integer.parseInt(input[j]);
                if(box[j][i] == 1){
                    q.add(new int[]{j, i});
                }
            }
        }

        // 상하좌우 방향 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int count = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] tomato = q.poll();
                int x = tomato[0];
                int y = tomato[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < M && ny < N && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            count++;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j<M; j++){
                if(box[j][i] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }
}
