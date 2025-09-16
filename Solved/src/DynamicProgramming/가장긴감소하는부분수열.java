package DynamicProgramming;

import java.io.*;
import java.util.*;

public class 가장긴감소하는부분수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = 0;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for(int i = 0; i <N; i++){
            for(int j = 0; j <i;j++){
                if(arr[j]>arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
