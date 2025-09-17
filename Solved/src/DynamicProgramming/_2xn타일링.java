package DynamicProgramming;

import java.io.*;
import java.util.*;

public class _2xn타일링 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[1] = 1;
        if (n >= 2) dp[2] = 2;
        for(int i = 3; i <n+1; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
