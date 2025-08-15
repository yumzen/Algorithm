package Hash;
import java.util.*;

public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        // 종류 별로 해시 맵에 저장
        for(String[] c: clothes){
            map.put(c[1], map.getOrDefault(c[1], 0)+1);
        }

        // 경우의 수 구하기
        for(Integer v : map.values()){
            answer*=(v + 1);
        }
        return answer-1;
    }
}
