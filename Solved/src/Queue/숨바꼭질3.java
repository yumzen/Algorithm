package Queue;

import java.io.*;
import java.util.*;

public class 숨바꼭질3 {
    static final int MAX = 200001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치

        int[] time = new int[MAX];
        Arrays.fill(time, -1);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(n);
        time[n] = 0;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            // 1. 순간이동 (우선순위 높음, 시간 +0)
            int teleport = cur * 2;
            if (teleport < MAX && time[teleport] == -1 ) {
                time[teleport] = time[cur];
                deque.addFirst(teleport); // ❗ 0초는 앞으로 넣음
            }

            // 2. 걷기 (뒤로 넣고 시간 +1)
            for (int next : new int[]{cur - 1, cur + 1}) {
                if (next >= 0 && next < MAX && time[next] == -1) {
                    time[next] = time[cur] + 1;
                    deque.addLast(next);
                }
            }
        }

        System.out.println(time[k]);
    }
}