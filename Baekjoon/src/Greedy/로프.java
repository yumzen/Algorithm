package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//2217 로프
public class 로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        Integer arr[] = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Integer max = 0;
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            if(max<arr[i] * (N-i)) max = arr[i]*(N-i);
        }
        System.out.println(max);
    }
}
