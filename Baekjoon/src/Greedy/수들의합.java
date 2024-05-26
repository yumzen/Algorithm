package Greedy;
// 1789 수들의 합

import java.util.Scanner;

public class 수들의합 {
    /*
    1부터 차례대로 더하다가 값이 초과되면, 현재까지 더한 숫자의 갯수-1로 구할 수 있다!
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();
        long sum = 0;
        long i = 0;
        while (sum <= n) {
            i += 1;
            sum += i;
        }
        System.out.println(i-1);
    }
}
