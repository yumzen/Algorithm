package BruteForcing;
/*
공식 찾기
1. yellow = x*y
2. brown = x+y+4
여기서 x, y는 yellow의 가로, 세로를 의미하며
brown은 yellow의 가로, 세로에 각각 2씩을 더한 값이다.
 */

public class 카펫 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = 1; i < brown; i++){
            for(int j = i; j<= (brown-i)/2; j++){
                if(i*j == yellow && 2*i+2*j+4 == brown){
                    answer[1] = i+2; // 가로 길이가 세로보다 길기 때문에 1이 가로
                    answer[0] = j+2;
                    return answer;
                }
            }
        }
        return answer;
    }
}
