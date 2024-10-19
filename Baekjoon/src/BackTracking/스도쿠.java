package BackTracking;

/*
 * 2580 스도쿠
 * https://www.acmicpc.net/problem/2580
 */
import java.io.*;

public class 스도쿠 {

    public static boolean isPossible(int[][] board, int x, int y, int num) {
        // 가로줄 검사
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num) {
                return false;
            }
        }

        // 세로줄 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == num) {
                return false;
            }
        }

        // 3x3 박스 검사
        int startRow = (x / 3) * 3;
        int startCol = (y / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true; // 해당 숫자를 놓을 수 있음
    }

    public static boolean sudoku(int[][] board) {
        // 빈 칸을 찾기
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    // 1부터 9까지 숫자 시도
                    for (int num = 1; num <= 9; num++) {
                        if (isPossible(board, i, j, num)) {
                            board[i][j] = num; // 숫자 넣기

                            // 재귀적으로 다음 칸을 탐색
                            if (sudoku(board)) {
                                return true;
                            }

                            // 실패한 경우, 다시 빈 칸으로 설정 (백트래킹)
                            board[i][j] = 0;
                        }
                    }
                    return false; // 가능한 숫자가 없으면 false
                }
            }
        }

        return true; // 모든 빈 칸을 채웠으면 true
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        if (sudoku(board)) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
