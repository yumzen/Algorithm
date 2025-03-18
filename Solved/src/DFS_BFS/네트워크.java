package DFS_BFS;

public class 네트워크 {
    // DFS를 사용하여 네트워크 탐색
    public void dfs(int[][] computers, int current, Boolean[] visited) {
        visited[current] = true;  // 현재 컴퓨터 방문 처리

        // 현재 컴퓨터와 연결된 다른 컴퓨터를 재귀적으로 방문
        for (int i = 0; i < computers.length; i++) {
            if (computers[current][i] == 1 && !visited[i]) {  // 연결되어 있고 방문하지 않은 경우
                dfs(computers, i, visited);  // 재귀 호출
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        Boolean[] visited = new Boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;  // 방문 처리 초기화
        }

        // 모든 컴퓨터를 확인
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {  // 아직 방문하지 않은 컴퓨터가 있으면
                dfs(computers, i, visited);  // DFS로 연결된 컴퓨터들을 모두 방문
                answer++;  // 하나의 네트워크를 찾았으므로 네트워크 개수 증가
            }
        }

        return answer;  // 네트워크의 개수를 반환
    }
}