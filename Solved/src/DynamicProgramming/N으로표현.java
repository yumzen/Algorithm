package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class N으로표현 {
    public int solution(int N, int number) {
        if(number == N) return 1;

        List<Integer>[][] dp = new ArrayList[9][9];
        // dp[i][j]: i개의 N을 사용하여 만들 수 있는 값들의 리스트

        // 초기화
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i < 9; i++) {
            int num = Integer.parseInt(String.valueOf(N).repeat(i)); // ex: N=5일 때 5, 55, 555, ...
            dp[i][0].add(num);
            if (num == number) return i; // 초기값으로 number를 만들 수 있다면 바로 반환
        }

        for(int i = 1; i < 9; i++){
            for(int j = 1; j <= i; j++){
                for (int num1 : dp[j][0]) {
                    for (int num2 : dp[i - j][0]) {
                        // 덧셈, 뺄셈, 곱셈, 나눗셈 연산
                        dp[i][0].add(num1 + num2); // 덧셈
                        dp[i][0].add(num1 - num2); // 뺄셈
                        dp[i][0].add(num1 * num2); // 곱셈
                        if (num2 != 0) dp[i][0].add(num1 / num2); // 나눗셈 (0으로 나누는 예외 처리)
                    }
                }
            }
            if (dp[i][0].contains(number)) return i;
        }
        return -1;
    }
}
