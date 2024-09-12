package BackTracking;
//9663 N-Queen
//https://www.acmicpc.net/problem/9663

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    static int count =0;

    public static boolean isPossible(int[][] board, int row, int i, int N){
        for(int j=0; j<row; j++){ // 같은 열에 퀸이 있는지 확인
            if(board[j][i] == 1) return false;
        }

        for(int j=row-1, k=i-1; j>=0 && k>=0; j--, k--){ // 왼쪽 대각선에 퀸이 있는지 확인
            if(board[j][k] == 1) return false;
        }

        for(int j=row-1, k=i+1; j>=0 && k<N; j--, k++){ // 오른쪽 대각선에 퀸이 있는지 확인
            if(board[j][k] == 1) return false;
        }

        return true;
    }

    public static void nqueen(int[][] board, int row, int N) {
        if(row == N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            if(isPossible(board, row, i, N)){
                board[row][i] = 1;
                nqueen(board, row+1, N);
                board[row][i] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        nqueen(board, 0, N);
        System.out.println(count);
    }
}
