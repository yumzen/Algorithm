package Hash;

import java.util.Arrays;
import java.util.stream.Collectors;

// 해시X 함수형 풀이
public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};

        Integer result =  Arrays.stream(nums)
                .boxed() // int[] -> Integer[]
                .collect(Collectors.collectingAndThen( // 중간 결과를 다른 형태로 변환
                        Collectors.toSet(), // 중복 제거
                        pocketmons -> Integer.min(pocketmons.size(), nums.length / 2) // 중복 제거한 폰켓몬 종류 수와 가져갈 수 있는 폰켓몬 수 중 작은 값
                        ));

        System.out.println(result);
    }
}

/* 나의 풀이
public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};

        // key: 폰켓몬 번호, value: 폰켓몬 번호의 개수
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num,9) + 1);
        }

        // 폰켓몬 종류 수
        int kind = map.size();

        // 가져갈 수 있는 폰켓몬 수는 map.size()로 두고, num.length / 2보다 같거나 작은 값으로만 출력
        if(kind <= nums.length / 2){
            System.out.println(kind);
        } else {
            System.out.println(nums.length / 2);
        }
    }
}
 */