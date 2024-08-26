package DataStructure.Queue;
//1158 요세푸스 문제
//https://www.acmicpc.net/problem/1158

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 요세푸스문제 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        Integer N = Integer.parseInt(str[0]);
        Integer K = Integer.parseInt(str[1]);
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i =0; i < N; i++){
            queue.add(i+1);
        }

        sb.append("<");
        while(!queue.isEmpty()){
            for(int i=0; i<K-1; i++){
                queue.add(queue.poll());
            }
            sb.append(queue.poll());
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
