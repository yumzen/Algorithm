package Heap;

import java.util.*;
import java.io.*;

public class 최소힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i <N; i++){
            input[i] = Integer.parseInt(br.readLine());
            if(input[i] != 0) pq.add(input[i]);
            if(input[i] == 0) {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
        }
    }
}
