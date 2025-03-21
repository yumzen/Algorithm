package BruteForcing;

public class 서버증설횟수 {
    public int solution(int[] players, int m, int k) {
        // 모든 시간대의 서버 증설 횟수를 0으로 초기화
        int[] servers = new int[players.length+1];
        int answer = 0;

        for(int i = 0 ; i < players.length ; i++){
            if(players[i] < m){
                continue;
            } else {
                if(servers[i] >= players[i]/m){
                    continue;
                } else {
                    // 현재 서버
                    int server = servers[i];

                    // 증설해야할 서버 개수
                    int need = players[i] / m - servers[i];
                    while(need > 0){
                        int j = i;
                        while(j < i+k && j < players.length){
                            servers[j++]++;
                        }
                        need--;
                        server++;
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
