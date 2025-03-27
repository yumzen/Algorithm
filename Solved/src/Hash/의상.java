package Hash;
import java.util.*;

public class 의상 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        // 1. 해시맵을 사용하여 각 의상 종류별 개수 저장
        for (String[] cloth : clothes) {
            String category = cloth[1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }

        // 2. 조합의 개수 계산
        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1); // (해당 종류의 의상을 선택하는 경우 + 선택하지 않는 경우)
        }

        return answer - 1;
    }
}
