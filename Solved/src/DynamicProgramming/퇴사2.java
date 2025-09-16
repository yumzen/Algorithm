package DynamicProgramming;

import java.io.*;
import java.util.*;

public class 퇴사2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            T[i] = Integer.parseInt(parts[0]);
            P[i] = Integer.parseInt(parts[1]);
        }

        // dp[i] = i일(0~i-1 처리 완료)까지 얻을 수 있는 최대 이익
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            // 오늘(시점 i)까지의 최댓값을 내일로 넘김(오늘 상담 안 함)
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // 오늘 상담을 하면 end일에 돈이 들어옴
            int end = i + T[i];
            if (end <= N) { // 퇴사일을 넘기지 않으면
                dp[end] = Math.max(dp[end], dp[i] + P[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
