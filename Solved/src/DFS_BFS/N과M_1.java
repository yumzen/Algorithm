package DFS_BFS;

import java.io.*;
import java.util.*;
public class N과M_1 {

    public static void dfs(Deque<Integer> stack, int n, int m){
        if(stack.size() == m){
            Deque<Integer> tmp = new ArrayDeque<>(stack);
            while(!tmp.isEmpty()){
                System.out.print(tmp.pollFirst() + " ");
            }
            System.out.println();
            return;
        }

        for(int j = 1; j<=n ; j++){
            if(!stack.contains(j)){
                stack.add(j);
                dfs(stack, n, m);
                stack.pollLast();
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Deque<Integer> stack = new ArrayDeque<>();
        dfs(stack, n, m);
    }
}
