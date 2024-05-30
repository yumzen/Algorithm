package Greedy;
//1417 국회의원 선거

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 국회의원선거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int me = Integer.parseInt(br.readLine());
        Integer arr[] = new Integer[n-1];
        int count = 0;

        if(n == 1) {
            System.out.println(0);
            return;
        }

        for(int i =0; i< n-1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        while (true){
            Arrays.sort(arr, Collections.reverseOrder()); //내림차순 정렬
            if(arr[0]< me) break;
            else{
                me++;
                arr[0]--;
                count++;
            }
        }

        System.out.print(count);
    }
}
