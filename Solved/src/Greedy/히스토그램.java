package Greedy;

import java.io.*;
import java.util.*;

public class 히스토그램 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] heights = new long[N];
        for(int i = 0; i<N; i++){
            heights[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        long max = 0;
        for (int i = 0; i <= N; i++) {
            long curr = (i == N ? 0 : heights[i]);
            // 현재 높이보다 크거나 같은 막대들은 pop하면서 면적 계산
            while (!stack.isEmpty() && heights[stack.peek()] >= curr) {
                int idx = stack.pop();         // 이번에 기준(가장 낮은) 막대
                long h = heights[idx];
                int left = stack.isEmpty() ? -1 : stack.peek(); // 왼쪽 경계(더 낮은 막대)
                long width = i - left - 1;                       // [left+1 .. i-1]
                long area = h * width;
                if (area > max) max = area;
            }

            stack.push(i); // 현재 인덱스는 반드시 push
        }

        System.out.println(max);

    }
}
