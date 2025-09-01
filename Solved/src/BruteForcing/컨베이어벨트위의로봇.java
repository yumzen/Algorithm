package BruteForcing;
import java.io.*;
import java.util.*;

public class 컨베이어벨트위의로봇 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Integer n = Integer.parseInt(input[0]);
        Integer k = Integer.parseInt(input[1]);
        String[] A_input = br.readLine().split(" ");
        Integer[] A = Arrays.stream(A_input).map(Integer::parseInt).toArray(Integer[]::new);
        boolean[] robot = new boolean[n];
        int step = 1;
        while(true) {
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            // 1-1 벨트 회전
            Integer tmp = A[A.length - 1];
            for (int i = A.length - 1; i >0; i--) {
                A[i] = A[i-1];
            }
            A[0] = tmp;
            // 1-2 로봇 회전
            for (int i = n-1; i > 0; i--) {
                robot[i] = robot[i-1];
            }
            robot[0] = false;

            // 즉시 내리기
            robot[n - 1] = false;

            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            // 단, 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            for (int i = n - 2; i >= 0; i--) {
                if(robot[i]){ // 로봇이 그 자리에 있다면
                    if(!robot[i+1] && A[i+1] >= 1){ // 이동할 수 있다면,
                        A[i+1]--;
                        robot[i+1]= true;
                        robot[i] = false;
                        i++;
                    }
                }
            }

            // 즉시 내리기
            robot[n - 1] = false;

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if(A[0] > 0){
                A[0]--;
                robot[0] = true;
            }

            // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            int count = 0;
            for(int i = 0; i <A.length; i++){
                if(A[i] == 0) count++;
            }
            if(count >= k) break;
            step++;
        }
        System.out.println(step);
    }
}
