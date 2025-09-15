package DynamicProgramming;

import java.io.*;
import java.util.*;

// 상태: dp[i][s] = i번째 수까지 사용했을 때 합 s(0..20)에 도달하는 경우의 수
public class 일학년 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] a = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long[][] dp = new long[N][21];

        // 초기값: 첫 수 a[0] 하나로 합 a[0]에 도달하는 경우는 1가지
        dp[0][a[0]] = 1;

        // i = 1 .. N-2 (마지막 수 a[N-1]은 타깃이므로 전이에 사용 X)
        for (int i = 1; i <= N - 2; i++) {
            for (int s = 0; s <= 20; s++) {
                if (dp[i - 1][s] == 0) continue;
                int plus = s + a[i];
                int minus = s - a[i];
                if (plus >= 0 && plus <= 20) dp[i][plus] += dp[i - 1][s];
                if (minus >= 0 && minus <= 20) dp[i][minus] += dp[i - 1][s];
            }
        }

        int target = a[N - 1];           // 만들어야 하는 최종 값
        System.out.println(dp[N - 2][target]);
    }
}
