package BinarySearch;

import java.util.Arrays;

public class 입국심사 {

    public static void main(String[] args){
        int n = 6;
        int[] times = {7, 10};

        // 소요 시간을 오름차순으로 정렬한다.
        Arrays.sort(times);

        // 심사 시간 중 최소값과 최대값을 구한다.
        long min = 1;
        long max = (long) times[times.length - 1] * (long) n;
        long answer = max;

        // 이분 탐색을 시작한다. 최소값이 최대값보다 작거나 같을 때까지 진행한다.
        while(min <= max){
            long mid = (min + max) / 2;

            // 각 심사관이 mid 시간 동안 처리할 수 있는 사람 수를 구한다.
            long sum = 0;
            for(int time: times){ // 각 심사대에 대해
                sum += mid / time;
            }

            // 처리한 사람 수가 n보다 크거나 같다면, 최대값을 줄이고 최소 시간을 갱신
            if(sum >= n) {
                answer = mid;
                max = mid - 1;
            }
            // 처리한 사람 수가 n보다 작다면, 최소값을 증가
            else {
                min = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
