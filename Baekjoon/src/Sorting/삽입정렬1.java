package Sorting;
// 24051 알고리즘 수업 - 삽입정렬1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삽입정렬1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for(int i = 1; i < N; i++){
            int tmp = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > tmp) {
                arr[j + 1] = arr[j];
                j--;
                count++;
                if(count == K) {
                    System.out.println(arr[j + 1]);
                    return;
                }
            }

            if (j + 1 != i) {
                arr[j + 1] = tmp;
                count++;
                if (count == K) {
                    System.out.println(tmp);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
