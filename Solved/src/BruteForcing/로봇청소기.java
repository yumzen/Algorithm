package BruteForcing;

/**
 * 14503 로봇청소기
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로봇청소기 {
    public static int cleanRoom(Integer[][] room, Integer r, Integer c, Integer direction, int count, int[] dr, int[] dc) {
        while (true) {
            // 1. 현재 칸 청소
            if (room[r][c] == 0) {
                room[r][c] = 2; // 청소 표시를 2로
                count++;
            }

            boolean moved = false;

            // 2. 주변 4칸 확인해서 청소 안된 칸 있는지 회전화면서 확인
            for (int i = 0; i < 4; i++) {
                direction = (direction + 3) % 4; // 반시계 방향으로 회전
                int newR = r + dr[direction];
                int newC = c + dc[direction];

                // 앞쪽 칸이 청소되어있지 않은 유효한 칸이라면 전진
                if (newR >= 0 && newR < room.length && newC >= 0 && newC < room[0].length && room[newR][newC] == 0) {
                    r = newR;
                    c = newC;
                    moved = true;
                    break;
                }
            }

            if (moved) continue;

            // 3. 4방향 모두 청소되어 있거나 벽인 경우 → 후진
            int backR = r - dr[direction];
            int backC = c - dc[direction];

            if (backR >= 0 && backR < room.length && backC >= 0 && backC < room[0].length && room[backR][backC] != 1) {
                r = backR;
                c = backC;
            } else {
                break; // 벽이면 종료
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] roomSize = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer[] robotPosition = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer[][] room = new Integer[roomSize[0]][roomSize[1]];
        for (int i = 0; i < roomSize[0]; i++) {
            room[i] = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int cleanedCount = cleanRoom(room, robotPosition[0], robotPosition[1], robotPosition[2], 0, dr, dc);
        System.out.println(cleanedCount);
    }
}
