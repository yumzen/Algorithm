package BackTracking;

/*
* 15649 N과 M (1)
* https://www.acmicpc.net/problem/15649
*/
import java.io.*;

public class N과M_1 {

    public static void backtracking(int N, int M, int[] arr, boolean[] visited, int index) {
        if (index == M) { // M개를 모두 뽑았을 때
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) { // 1부터 N까지 수열에 넣기
            if (visited[i]) continue; // 이미 수열에 들어있는 수라면 건너뛰기
            visited[i] = true; // 수를 방문 처리
            arr[index] = i; // 수열에 수 넣기
            backtracking(N, M, arr, visited, index + 1); // 다음 수 넣기
            visited[i] = false; // 백트래킹이 끝나면 방문 여부를 해제
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[M]; // 선택한 수를 저장할 배열
        boolean[] visited = new boolean[N + 1]; // 방문 여부를 확인할 배열

        backtracking(N, M, arr, visited, 0); // 초기 index는 0
    }
}
