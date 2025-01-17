package Hash;

import java.util.HashMap;
import java.util.Map;

// 해시 사용 풀이
public class 완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        // 참여자들은 map으로 넣어둔다.
        for(String player: participant){
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        // 완주자들은 map에서 빼준다.
        for(String player: completion){
            map.put(player, map.get(player) - 1);
        }

        // 완주하지 못한 선수는 value가 1인 key를 출력한다.
        for(String key: map.keySet()){
            if(map.get(key) == 1){
                answer = key;
            }
        }

        System.out.println(answer);
    }
}
