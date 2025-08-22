package DFS_BFS;

import java.io.*;
import java.util.*;

public class N과M_2 {
    public static void dfs(int n, int m, Deque<Integer> stack, int start) {
        if(stack.size() == m) {
            for (int v : stack) {
                System.out.print(v + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            stack.addLast(i);
            dfs(n, m, stack, i + 1); // 다음 숫자는 i+1부터 시작 (오름차순)
            stack.removeLast();
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Deque<Integer> stack = new ArrayDeque<>();
        dfs(n, m, stack, 1);
    }
}
