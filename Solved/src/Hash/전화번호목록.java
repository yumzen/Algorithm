package Hash;

import java.util.*;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        for(String phone: phone_book){
            map.put(phone, 0);
        }

        for(String phone: map.keySet()){
            for(int i = 0 ; i <= phone.length(); i++){
                if(map.containsKey(phone.substring(0, i))){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}