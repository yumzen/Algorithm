package Tree;

import java.io.*;
import java.util.*;

public class 뉴스전하기 {
    public static int dfs(int index, List<List<Integer>> children){
        // 현재 직원의 자식(직속 부하)들이 뉴스를 다 전하는 데 걸리는 시간들을 저장
        List<Integer> times = new ArrayList<>();

        // 모든 자식(직속 부하)에 대해 재귀 호출 -> 자식이 뉴스를 끝내는 시간 계산
        for (int v : children.get(index)) {
            times.add(dfs(v, children));
        }

        // 자식이 없으면 (leaf 노드 = 더 전할 곳 없음) → 0분 소요
        if (times.isEmpty()) return 0;

        // 오래 걸리는 자식부터 먼저 전화해야 전체 시간이 최소
        times.sort(Collections.reverseOrder());

        int best = 0; // 현재 직원이 모든 자식에게 뉴스를 전파 완료하는 시간
        // i번째 자식에게 전화를 걸 때: 자식의 전파 시간 + (i+1)분 (자식에게 전화 거는 순서)
        for (int i = 0; i < times.size(); i++) {
            best = Math.max(best, times.get(i) + (i + 1));
        }
        return best;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> children = new ArrayList<>(N);
        for (int i = 0; i < N; i++) children.add(new ArrayList<>());
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for(int i = 0; i < N; i++) {
            int num = input[i];
            if (num == -1) continue;
            children.get(num).add(i); //상사의 children에 i번째 수 추가
        }
        System.out.println(dfs(0, children));
    }
}
