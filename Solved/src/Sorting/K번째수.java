package Sorting;

import java.io.*;
import java.util.*;

public class K번째수 {
    public static void mergeSort(int[] arr, int left, int right){
        if(left == right)
            return;
        int mid = (left+right)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        // 왼쪽 배열 담기
        for(int i=0; i<leftArr.length; i++){
            leftArr[i] = arr[left];
        }
        //오른쪽배열 담기
        for(int i=0; i<rightArr.length; i++){
            rightArr[i] = arr[mid+i];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while(i<leftSize && j< rightSize){
            if(leftArr[i]<rightArr[j]) {
                arr[k] = rightArr[j];
                j++;
            } else {
                arr[k] = leftArr[i];
                j++;
            }
            k++;
        }
        while(i<leftSize){
            arr[k++] = leftArr[i++];
        }
        while(j<rightSize){
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) throws IOException {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        for ( int[] com: commands){
            int i = com[0] - 1; // 1-based index이므로 -1
            int j = com[1];     // copyOfRange는 exclusive이므로 그대로 유지
            int k = com[2] - 1; // 1-based index이므로 -1

            int[] arr = Arrays.copyOfRange(array, i, j);
            mergeSort(arr, 0, arr.length-1);
            System.out.println(arr[k]);
        }
    }
}
