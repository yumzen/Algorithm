package Hash;

import java.io.*;
import java.util.*;

public class 문자열집합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 문자열의 개수
        int M = Integer.parseInt(input[1]); // 찾을 문자열의 개수
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < N; i++) {
            set.add(br.readLine()); // 문자열 집합에 추가
        }

        int answer = 0;
        for(int i = 0 ; i < M; i ++){
            String str = br.readLine();
            if(set.contains(str)) answer++;
        }
        System.out.println(answer); // 찾은 문자열의 개수 출력
    }
}
