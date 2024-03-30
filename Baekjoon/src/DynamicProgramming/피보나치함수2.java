package DynamicProgramming;
// 2748 피보나치 함수2

import java.io.*;

public class 피보나치함수2 {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //arr는 N+1만큼만 생성. 또한 long으로 초기화 시 초기값은 0
        arr = new long[N+1];

        //arr 초기화
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i < N + 1; i++) {
            arr[i] = -1;
        }

        System.out.println(fibonacci(N));
    }
    static long fibonacci(int N) {
        if(arr[N] == -1){
            arr[N] = fibonacci(N-1) + fibonacci(N-2);
        }
        return arr[N];
    }
}