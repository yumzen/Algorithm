package Sorting;

//23968 알고리즘 수업 - 버블정렬1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 버블정렬1 {

    public static void swap(int[] arr, int i, int j){
        int tmp= arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count =0;
        for(int i =0; i<arr.length-1; i++){
            for(int j =0; j< arr.length-i-1; j++){
                if(arr[j]>arr[j+1]) {
                    count++;
                    swap(arr, j, j+1);
                    if(count==K)  System.out.println(arr[j] + " "+ arr[j+1]);
                }
            }
        }
        if(count< K){
            System.out.println(-1);
        }
    }
}
