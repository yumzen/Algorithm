package Hash;

import java.util.*;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 1. HashSet 만들기
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i <phone_book.length ; i++){
            set.add(phone_book[i]);
        }

        // 2. 접두어 확인하기
        for (String num : phone_book) {
            for (int i = 1; i < num.length(); i++) {
                if (set.contains(num.substring(0, i))) {
                    return false;
                }
            }
        }
        return answer;
    }
}