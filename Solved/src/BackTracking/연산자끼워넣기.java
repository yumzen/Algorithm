package BackTracking;

/**
 * 백준 14888번: 연산자 끼워넣기
 * 문제 링크: https://www.acmicpc.net/problem/14888
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    static int N;
    static int[] numbers;
    static int[] operators; // +, -, *, /
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void dfs(int index, int currentValue) {
        if (index == N) {
            maxResult = Math.max(maxResult, currentValue);
            minResult = Math.min(minResult, currentValue);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                int nextValue = 0;
                switch (i) {
                    case 0: nextValue = currentValue + numbers[index]; break;
                    case 1: nextValue = currentValue - numbers[index]; break;
                    case 2: nextValue = currentValue * numbers[index]; break;
                    case 3: nextValue = currentValue / numbers[index]; break;
                }

                dfs(index + 1, nextValue);
                operators[i]++; // 백트래킹
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 숫자의 개수
        numbers = new int[N];
        operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);
        System.out.println(maxResult);
        System.out.println(minResult);
    }
}