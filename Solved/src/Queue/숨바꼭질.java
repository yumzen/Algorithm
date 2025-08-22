package Queue;

import java.io.*;
import java.util.*;


public class 숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치

        boolean[] visited = new boolean[200001];
        Deque<Integer> queue = new ArrayDeque<>();
        int[] time = new int[200001];
        Arrays.fill(time, -1);
        queue.add(n);
        visited[n] = true;
        time[n] = 0;
        while(true){
            n = queue.poll();
            if(n==k) {
                System.out.println(time[n]);
                return;
            }
            if(n - 1 >= 0 && n -1 < 200001 &&!visited[n-1]) {
                queue.add(n-1);
                visited[n-1] = true;
                time[n-1] = time[n]+1;
            }
            if(n +1 < 200001 &&!visited[n+1]) {
                queue.add(n+1);
                visited[n+1] = true;
                time[n+1] = time[n]+1;
            }
            if(n * 2 < 200001 && !visited[n*2]) {
                queue.add(n*2);
                visited[n*2] = true;
                time[n*2] = time[n]+1;
            }
        }
    }
}
