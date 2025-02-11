package Greedy;

/*
11047 동전0
- 그리디 알고리즘
- 가장 큰 동전부터 사용하여 최소 동전 개수를 구한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] <= k) {
                count += k / arr[i];  // 해당 동전으로 만들 수 있는 개수 추가
                k %= arr[i];  // 남은 금액 업데이트
            }
        }

        System.out.println(count);
    }
}