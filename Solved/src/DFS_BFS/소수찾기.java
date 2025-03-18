package DFS_BFS;

import java.util.*;

public class 소수찾기 {

    // 소수 판별 함수
    public boolean isPrime(Integer number) {
        if (number == 0 || number == 1) return false; // 0과 1은 소수가 아님
        for (int i = 2; i <= Math.sqrt(number); i++) { // 2부터 number의 제곱근까지 나누어 나누어 떨어지면 소수가 아님
            if (number % i == 0) return false;
        }
        return true;
    }

    // DFS를 통한 모든 가능한 숫자 조합을 찾아 소수를 판별
    public void dfs(String[] number, Set<Integer> set, String current, Boolean[] visited) {
        // current가 비어 있지 않으면 소수를 판별하여 set에 추가
        if (!current.isEmpty()) {
            Integer num = Integer.parseInt(current);
            if (isPrime(num)) {
                set.add(num);
            }
        }

        // DFS를 통해 가능한 모든 숫자 조합 생성
        for (int i = 0; i < number.length; i++) {
            if (!visited[i]) { // 이미 방문한 숫자는 사용하지 않음
                visited[i] = true; // 숫자 방문 처리
                dfs(number, set, current + number[i], visited); // 숫자 추가하여 DFS 호출
                visited[i] = false; // 백트래킹
            }
        }
    }

    // 소수를 찾는 메인 함수
    public int 소수찾기(String numbers) {
        Set<Integer> set = new HashSet<>(); // 소수를 저장할 Set
        String[] number = numbers.split(""); // 입력받은 문자열을 문자 배열로 분리
        Boolean[] visited = new Boolean[number.length]; // 방문 여부 배열
        Arrays.fill(visited, false); // 방문 여부 배열을 false로 초기화

        // DFS를 이용하여 가능한 모든 숫자 조합을 찾아 소수 개수를 구함
        dfs(number, set, "", visited);

        // 소수 개수를 반환
        return set.size();
    }

}