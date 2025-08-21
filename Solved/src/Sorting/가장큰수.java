package Sorting;

import java.util.*;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] array = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(array, (a, b) -> (b + a).compareTo(a + b));
        for(int i = 0; i < array.length; i++){
            answer += array[i];
        }

        return answer.startsWith("0") ? "0" : answer;
    }
}
