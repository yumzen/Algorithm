package DataStructure.Stack;

//1874 스택 수열
//https://www.acmicpc.net/problem/1874

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int current = 1;
        boolean isPossible = true;

        for (int index = 0; index < N; index++) {
            int value = Integer.parseInt(br.readLine());

            // 현재 수열의 값이 스택의 맨 위에 있는 값과 같을 때까지 push
            while (current <= value) {
                stack.push(current++);
                sb.append("+\n");
            }

            // 스택의 맨 위에 있는 값이 수열의 값과 같으면 pop
            if (!stack.isEmpty() && stack.peek() == value) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 수열의 값이 스택의 맨 위에 있는 값과 다르면 수열이 불가능함
                isPossible = false;
                break;
            }
        }

        // 모든 수열을 처리한 후 스택이 비어 있는지 확인
        if (!isPossible || !stack.isEmpty()) {
            System.out.println("NO");
            return;
        }

        System.out.println(sb);
    }
}
