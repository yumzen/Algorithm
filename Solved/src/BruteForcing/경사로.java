package BruteForcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 경사로 {
    public static boolean checkLine(int[] line, int L) {
        boolean[] used = new boolean[line.length];

        for (int i = 0; i < line.length - 1; i++) {
            int diff = line[i] - line[i + 1];

            if (diff == 0) continue;

            if (diff == 1) {
                // 내려가는 경사로
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= line.length || line[j] != line[i + 1] || used[j]) return false;
                    used[j] = true;
                }
            } else if (diff == -1) {
                // 올라가는 경사로
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || line[j] != line[i] || used[j]) return false;
                    used[j] = true;
                }
            } else {
                return false; // 높이 차가 2 이상
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (checkLine(map[i], L)) count++;

            int[] col = new int[N];
            for (int j = 0; j < N; j++) col[j] = map[j][i];
            if (checkLine(col, L)) count++;
        }

        System.out.println(count);
    }
}