package DynamicProgramming;
//10826 피보나치함수4
import java.io.*;
import java.math.BigInteger;

public class 피보나치함수4 {
    static BigInteger[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //arr는 N+1만큼만 생성. 또한 long으로 초기화 시 초기값은 0
        arr = new BigInteger[N+2];

        //arr 초기화
        arr[0] = BigInteger.valueOf(0);
        arr[1] = BigInteger.valueOf(1);
        for(int i = 2; i < N + 1; i++) {
            arr[i] = BigInteger.valueOf(-1);
        }

        System.out.println(fibonacci(N));
    }
    static BigInteger fibonacci(int N) {
        if(arr[N].equals(BigInteger.valueOf(-1))){
            arr[N] = fibonacci(N-1).add(fibonacci(N-2));
        }
        return arr[N];
    }
}
