package DynamicProgramming;

import java.io.*;

public class LCS2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        //dp[i][j] = 첫 번째 문자열의 앞에서 i개,두 번째 문자열의 앞에서 j개를 봤을 때의 LCS 길이
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 1; i<=s1.length(); i++){
            for(int j = 1; j<=s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int i = s1.length();
        int j = s2.length();
        StringBuilder answer = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                answer.append(s1.charAt(i - 1));
                i--; j--;
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1]) i--;
                else j--;
            }
        }
        answer.reverse();

        System.out.println(dp[s1.length()][s2.length()]);
        System.out.println(answer);
    }
}
