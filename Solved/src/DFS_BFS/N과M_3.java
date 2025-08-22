package DFS_BFS;


import java.io.*;
import java.util.*;

public class N과M_3 {
    public static Deque<Integer> stack = new ArrayDeque<>();
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int n, int m){
        if(stack.size() == m){
            for(int i: stack){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= n; i ++) {
            stack.addLast(i);
            dfs(n, m);
            stack.pollLast();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        dfs(n, m);
        System.out.print(sb);
    }
}

