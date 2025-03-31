package Queue;

import java.util.*;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int[] answer = {};
        for(int i = 0 ; i < arr.length; i++){
            if(!queue.isEmpty() && queue.getLast() == arr[i])
                continue;
            else
                queue.add(arr[i]);
        }
        return queue.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args){
        같은숫자는싫어 test = new 같은숫자는싫어();
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(test.solution(arr)));
    }
}
