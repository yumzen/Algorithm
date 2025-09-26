package etc;

public class 유연근무제 {
    class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int answer = 0;
            for(int i = 0; i<schedules.length; i++){
                int day = startday;
                int min = schedules[i];
                int max = min+10;
                boolean late = false;
                if(max % 100 >= 60){
                    max+=40;
                }

                for(int j = 0; j<7 ; j++){
                    if(day == 6 || day == 7) {
                        day++;
                        if(day == 8) day = 1;
                        continue;
                    }
                    if(timelogs[i][j] > max) {
                        late = true;
                        break;
                    }
                    day++;
                }
                if(!late) answer++;
            }
            return answer;
        }
    }
}
