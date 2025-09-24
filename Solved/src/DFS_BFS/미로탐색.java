package DFS_BFS;

import java.io.*;
import java.util.*;


public class 미로탐색 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        Integer N = Integer.parseInt(input[0]);
        Integer M = Integer.parseInt(input[1]);
        int[][] graph = new int[N][M];
        for(int i = 0; i <N; i++){
            String[] s = br.readLine().split("");
            graph[i] = Arrays.stream(s)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        graph[0][0] = 1;

        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            if(xy[0]==N-1 && xy[1] == M-1) break;
            for(int i = 0; i<4; i++){
                int next_x = xy[0] + dx[i];
                int next_y = xy[1] + dy[i];
                if(next_x>=0 && next_x<N && next_y<M && next_y>=0){
                    if(graph[next_x][next_y] == 1) {
                        queue.add(new int[]{next_x, next_y});
                        graph[next_x][next_y] = 0;
                        graph[next_x][next_y] = graph[xy[0]][xy[1]] + 1;
                    }
                }
            }
        }
        System.out.println(graph[N-1][M-1]);
    }
}
