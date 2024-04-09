package DynamicProgramming;
// 14916 거스름돈

import java.io.*;
import java.util.Scanner;

import static java.lang.Integer.min;

public class 거스름돈 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] change = new int[100001];

        change[0] = -1;
        change[1] = -1;
        change[2] = 1;
        change[3] = -1;
        change[4] = 2;
        change[5] = 1;

        for(int i=6; i<n+1; i++){
            if(change[i-5]!=-1 && change[i-2]!=-1){
                 change[i] = min(change[i - 2], change[i - 5])+1;
            }else if(change[i-5]!= -1){
                change[i] = change[i - 5] + 1;
            }else if(change[i-2]!= -1) {
                change[i] = change[i - 2] + 1;
            }else{
                change[i] = -1;
            }
        }
        System.out.println(change[n]);
    }
}
