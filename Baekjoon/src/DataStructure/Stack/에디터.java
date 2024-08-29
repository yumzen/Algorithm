package DataStructure.Stack;

//1406 에디터
//https://www.acmicpc.net/problem/1406

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 에디터 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Deque<Character> left= new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for(char c: str.toCharArray()){
            left.addLast(c);
        }

        Integer N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            switch (input.charAt(0)) {
                case 'L':
                    if (!left.isEmpty()) {
                        right.addFirst(left.pollLast());
                    }
                    break;
                case 'D':
                    if (!right.isEmpty()) {
                        left.addLast(right.pollFirst());
                    }
                    break;
                case 'B':
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                    break;
                case 'P':
                    char c = input.charAt(2);
                    left.addLast(c);
                    break;
            }
        }

        while (!left.isEmpty()) {
            sb.append(left.pollFirst());
        }
        while (!right.isEmpty()) {
            sb.append(right.pollFirst());
        }

        /*
        만약 이렇게 하면 pollFirst하면서 size가 변하므로 모든 left의 값들을 꺼내올 수 없음. 그리고 반복문을 개선하기 위해 위와같이 사용함.
        while(!right.isEmpty()){
            left.addLast(right.pollFirst());
        }

        for(int i=0; i<left.size(); i++){
            sb.append(left.pollFirst());
        }
         */

        System.out.println(sb);
    }
}
