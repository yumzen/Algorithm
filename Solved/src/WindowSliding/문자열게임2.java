package WindowSliding;

import java.io.*;
import java.util.*;

public class 문자열게임2 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String str = br.readLine();
            Integer k = Integer.parseInt(br.readLine());
            Map<Character, Deque<Integer>> game = new HashMap<>();
            int min = Integer.MAX_VALUE;
            int max = -1;
            for(int j = 0; j <str.length(); j++){
                Character c = str.charAt(j);
                Deque<Integer> q = game.computeIfAbsent(c, x -> new ArrayDeque<>());
                q.addLast(j);
                game.put(c, q);
                if (q.size() == k) {
                    int len = q.peekLast() - q.peekFirst() + 1; // 양끝 포함
                    min = Math.min(min, len);
                    max = Math.max(max, len);
                    q.pollFirst(); // 슬라이딩
                }
            }

            if (max == -1) System.out.println(-1);
            else System.out.println(min + " " + max);
        }

    }
}
