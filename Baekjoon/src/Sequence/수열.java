package Sequence;

import java.io.*;

/*
* 2559 수열
* https://www.acmicpc.net/problem/2559
 */

public class 수열 {
    public static int sum = Integer.MIN_VALUE;

    public static void measurement(int[] arr, int N, int K) {
        for (int i = 0; i <= N - K; i++) {
            int temp = 0;
            for (int j = i; j < i + K; j++) {
                temp += arr[j];
            }
            if (temp > sum) {
                sum = temp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        measurement(arr, N, K);

        System.out.println(sum);
    }
}
