package DataStructure.Stack;

//9093 단어 뒤집기
//https://www.acmicpc.net/problem/9093

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 단어뒤집기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Integer T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");
            for (String word : str) {
                Deque<Character> stack = new ArrayDeque<>();
                for (char c : word.toCharArray()) {
                    stack.addFirst(c);
                }
                while (!stack.isEmpty()) {
                    sb.append(stack.pollFirst());
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
