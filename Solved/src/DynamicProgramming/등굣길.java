package DynamicProgramming;

import java.util.*;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int[] puddle : puddles) {
            dp[puddle[0] - 1][puddle[1] - 1] = -1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1) continue;  // 물에 잠긴 지역은 건너뛰기
                if(i>0 && dp[i-1][j] != -1) dp[i][j] += dp[i-1][j]%1000000007;
                if(j>0 && dp[i][j-1] != -1) dp[i][j] +=dp[i][j-1]%1000000007;
            }
        }
        return dp[m-1][n-1]%1000000007;
    }
}
