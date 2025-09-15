package DFS_BFS;

import java.io.*;
import java.util.*;
public class N과M_4 {
    public static void dfs(Deque<Integer> stack, Integer N, Integer M){
        if(stack.size() == M){
            Deque<Integer> output = new ArrayDeque<>(stack);
            while(!output.isEmpty()){
                System.out.print(output.pop()+ " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= N; i++){
            // 내림차순인 경우 i++
            if(!stack.isEmpty() && stack.getLast()>i) continue;
            stack.addLast(i);
            dfs(stack, N, M);
            stack.pollLast();
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Integer N = Integer.parseInt(input[0]);
        Integer M = Integer.parseInt(input[1]);
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(stack, N, M);
    }
}
