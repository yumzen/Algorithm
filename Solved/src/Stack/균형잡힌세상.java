package Stack;

import java.io.*;
import java.util.*;

public class 균형잡힌세상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            Deque<Character> stack = new ArrayDeque<>();
            String str = br.readLine();
            // 종료조건: 마지막에 온전하나가 오면 종료
            if (str.equals(".")) break;
            boolean isBalanced = true;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                switch (c) {
                    case ('['):
                        stack.push('[');
                        break;
                    case (']'):
                        if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                        else isBalanced = false;
                        break;
                    case ('('):
                        stack.push('(');
                        break;
                    case (')'):
                        if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                        else isBalanced = false;
                        break;
                }
            }
            if (!stack.isEmpty()) isBalanced = false;
            System.out.println(isBalanced ? "yes" : "no");
        }
    }
}
