package BruteForcing;
//1436 영화감독 숌

import java.io.IOException;
import java.util.Scanner;

/*
666 2666 3666 4666 5666 6660 ~ 6669 7666 8666 9666
 */
public class 영화감독숌 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int num = 666;
        int count = 1;

        while(count != N) {
            num++;
            if(String.valueOf(num).contains("666")) {
                count++;
            }
        }
        System.out.println(num);
    }
}
