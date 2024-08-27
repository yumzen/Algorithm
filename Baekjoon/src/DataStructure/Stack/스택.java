package DataStructure.Stack;

//10828 스택
//https://www.acmicpc.net/problem/10828

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 스택 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Integer N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i< N; i++){
            String str = br.readLine();

            if(str.split(" ")[0].equals("push")) {
                stack.addFirst(Integer.parseInt(str.split(" ")[1]));
            } else if(str.equals("top")){
                if(stack.isEmpty()){
                    sb.append("-1\n");
                } else {
                    sb.append(stack.peekFirst() + "\n");
                }
            } else if(str.equals("pop")){
                if(stack.isEmpty()){
                    sb.append("-1\n");
                } else {
                    sb.append(stack.pollFirst() + "\n");
                }
            } else if(str.equals("size")){
                sb.append(stack.size() + "\n");
            } else if(str.equals("empty")){
                if(stack.isEmpty()){
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }

        System.out.println(sb);
    }
}
