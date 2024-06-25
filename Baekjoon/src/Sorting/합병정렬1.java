package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//24060 합병정렬1
public class 합병정렬1 {

    static int K;
    static int count = 0;
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, mid, right);
        }
    }

    public static void merge(int[] arr, int[] tmp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tmp[i] = arr[i];
        }

        int part1 = left; // 배열1
        int part2 = mid + 1; // 배열2
        int index = left;

        while (part1 <= mid && part2 <= right) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1++];
            } else {
                arr[index] = tmp[part2++];
            }
            count++;
            if (count == K) {
                System.out.println(arr[index]);
                return;
            }
            index++;
        }

        while (part1 <= mid) {
            arr[index++] = tmp[part1++];
            count++;
            if (count == K) {
                System.out.println(arr[index - 1]);
                return;
            }
        }

        while (part2 <= right) {
            arr[index++] = tmp[part2++];
            count++;
            if (count == K) {
                System.out.println(arr[index - 1]);
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] tmp = new int[arr.length];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, tmp, 0, N - 1);

        if (count < K) {
            System.out.println(-1);
        }
    }
}