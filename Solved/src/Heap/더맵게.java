package Heap;

import java.util.*;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0 ; i<scoville.length; i++){
            minHeap.offer(scoville[i]);
        }
        while(true){
            if(minHeap.peek() >= K) break;
            if(minHeap.size() < 2) break;
            answer++;
            int v1 = minHeap.poll();
            int v2 = minHeap.poll();
            minHeap.offer(v1+2*v2);
        }
        return minHeap.peek() >= K ? answer : -1;
    }
}
