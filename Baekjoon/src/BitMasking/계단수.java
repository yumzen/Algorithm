package BitMasking;

/*
* 1562 계단수
* https://www.acmicpc.net/problem/1562
 */
import java.io.*;

/*
* dp + bitmasking 풀이
 */
public class 계단수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int mod = 1000000000;
        int[][][] dp = new int[N+1][10][1<<10];
        for(int i = 1; i < 10; i++){
            dp[1][i][1<<i] = 1; // 1자리 계단수는 0~9까지 1개씩(각 숫자에 비트마스킹한 배열에 1 저장)
        }

        for(int i = 2; i <= N; i++){ // 2자리부터 N자리까지 계단수를 차례대로 구하기
            for(int j = 0; j < 10; j++){ //마지막 숫자
                for(int k = 0; k < (1<<10); k++){ //비트마스크한 결과를 10진수로 변환했을 때 0부터 1023까지 가
                    if(j == 0){
                        dp[i][j][(1 << j) | k] = (dp[i][j][(1 << j) | k] + dp[i-1][j+1][k]) % mod;
                    } else if(j == 9){
                        dp[i][j][(1 << j) | k] = (dp[i][j][(1 << j) | k] + dp[i-1][j-1][k]) % mod;
                    } else {
                        dp[i][j][(1 << j) | k] = (dp[i][j][(1 << j) | k] + dp[i-1][j-1][k] + dp[i-1][j+1][k]) % mod;
                    }
                }
            }
        }

        int result = 0;
        for(int i = 0; i < 10; i++){
            result = (result + dp[N][i][(1<<10)-1]) % mod;
        }
        System.out.println(result);
    }
}

/*
* dfs 풀이
public class 계단수 {
    public static int count = 0;

    public static void dfs(int N, int num, int bit){
        if(num == N){
            count++;
            return;
        }

        if (bit == 9){
            dfs(N, num+1, bit-1);
        } else if (bit == 0) {
            dfs(N, num+1, bit+1);
        } else {
            dfs(N, num+1, bit-1);
            dfs(N, num+1, bit+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N<10){
            System.out.println(9);
        } else {
            dfs(N, 10, 9);
        }

        System.out.println(count);
    }
}

 */
