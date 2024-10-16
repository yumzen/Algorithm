package Sequence;

/*
* 1182 부분수열의 합
* https://www.acmicpc.net/problem/1182
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분수열의합 {
    public static int count = 0;
    public static void backtracking(int[] arr, int index, int sum, int S) {
        if (index == arr.length) {
            if (sum == S) {
                count++;
            }
            return;
        }

        //현재 원소를 포함하는 경우
        backtracking(arr, index + 1, sum + arr[index], S);

        //현재 원소를 포함하지 않는 경우(그대로 함수 전달)
        backtracking(arr, index + 1, sum, S);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        backtracking(arr, 0, 0, S);

        // 공집합을 제외하는 경우 (S가 0일 때만)
        if (S == 0) {
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }
    }
}
