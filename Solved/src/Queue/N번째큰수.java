package Queue;

import java.io.*;
import java.util.*;

public class N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i <N; i++){
            int[] input = Arrays.stream(br.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for(int j = 0; j<N; j++){
                pq.add(input[j]);
            }
        }
        int count = 1;
        while(true){
            int num = pq.remove();
            if(count == N) {
                System.out.println(num);
                break;
            }
            count++;
        }
    }
}
