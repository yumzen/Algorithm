package Greedy;

import java.util.*;

public class 큰수만들기 {

    class Solution {
        public String solution(String number, int k) {
            String answer = "";
            Deque<Integer> stack = new ArrayDeque<>();

            int count = 0;
            for(int i = 0; i <number.length(); i++){
                Integer cur = Integer.parseInt(String.valueOf(number.charAt(i)));
                while (!stack.isEmpty() && stack.peek() < cur && count < k) {
                    stack.pop();
                    count++;
                }
                stack.push(cur);
            }

            while (count < k) {
                stack.pop();
                count++;
            }

            int size = stack.size();
            for(int i = 0; i < size; i++){
                answer+= String.valueOf(stack.pollLast());
            }

            return answer;
        }
    }
}
