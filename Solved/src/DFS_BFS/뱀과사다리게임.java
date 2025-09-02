package DFS_BFS;

import java.io.*;
import java.util.*;

public class 뱀과사다리게임 {
    //        if(ladder.containsKey(current)) bfs(ladder, snake, current+ladder.get(current), count); //사다리 타기
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Integer N = Integer.parseInt(input[0]); // 사다리수
        Integer M = Integer.parseInt(input[1]); // 뱀수
        HashMap<Integer, Integer> ladder = new HashMap<>();
        HashMap<Integer, Integer> snake = new HashMap<>();
        for(int i = 0; i <N; i++){
            String[] str = br.readLine().split(" ");
            Integer departure = Integer.parseInt(str[0]);
            Integer arrival = Integer.parseInt(str[1]);
            ladder.put(departure, arrival);
        }
        for(int i = 0; i <M; i++){
            String[] str = br.readLine().split(" ");
            Integer departure = Integer.parseInt(str[0]);
            Integer arrival = Integer.parseInt(str[1]);
            snake.put(departure, arrival);
        }

        boolean[] visited = new boolean[101];
        Deque<int[]> q = new ArrayDeque<>(); // {현재칸, 굴린횟수}
        q.add(new int[]{1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0], dist = cur[1];
            if (pos == 100) {
                System.out.println(dist);
                return;
            }
            for (int d = 1; d <= 6; d++) {
                int nx = pos + d;
                if (nx > 100) continue;

                // 사다리/뱀 적용
                if(ladder.containsKey(nx)) nx = ladder.get(nx);
                if(snake.containsKey(nx)) nx = snake.get(nx);

                if (!visited[nx]) {
                    visited[nx] = true;
                    q.add(new int[]{nx, dist + 1});
                }
            }
        }
    }
}
