package DynamicProgramming;
//2156 포도주 시식
import java.io.*;

public class 포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n+1];
        for(int i =1; i<n+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = arr[1];

        if(n>1){
            dp[2] = arr[2]+ arr[1];
        }

        for(int i=3; i<n+1; i++){
            dp[i] = Math.max(dp[i-3]+arr[i]+arr[i-1], dp[i-2]+arr[i]);
            dp[i] = Math.max(dp[i],dp[i-1]);
        }
        System.out.println(dp[n]);

    }
}
