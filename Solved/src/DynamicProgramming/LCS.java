package DynamicProgramming;

import java.io.*;

public class LCS {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        //dp[i][j] = 첫 번째 문자열의 앞에서 i개,두 번째 문자열의 앞에서 j개를 봤을 때의 LCS 길이
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }
}