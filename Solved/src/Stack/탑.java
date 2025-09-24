package Stack;

import java.io.*;
import java.util.*;

public class 탑 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(input[i]);
        }

        StringBuilder sb = new StringBuilder();

        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = 0; i<N; i++){
            int h = heights[i];

            while(!stack.isEmpty() && stack.peek()[1] < h){
                stack.pop();
            }

            if(stack.isEmpty()) sb.append("0");
            else sb.append(stack.peek()[0]+1);

            if(i<N-1) sb.append(' ');

            stack.push(new int[]{i, h});
        }
        System.out.println(sb.toString());
        /*

        for(int i = 0; i< N; i++){
            if(i == 0){
                sb.append(0 + " ");
                continue;
            }
            for(int j = i-1; j>=0; j--){
                if(heights[i] < heights[j]) {
                    sb.append(j+1 + " ");
                    break;
                }
                else if(j == 0) sb.append(0 + " ");
            }
        }
        System.out.println(sb);
         */

    }
}
