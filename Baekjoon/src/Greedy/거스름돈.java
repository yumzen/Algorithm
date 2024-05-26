package Greedy;
//5585 거스름돈

import java.io.IOException;
import java.util.Scanner;

public class 거스름돈 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int change = 1000-n;
        int ch = 0;
        while(change>0){
            if(change>=500){
                change-=500;
                ch++;
            }else if(change>=100){
                change-=100;
                ch++;
            }else if(change>=50){
                change-=50;
                ch++;
            }
            else if(change>=10){
                change-=10;
                ch++;
            }else if(change>=5){
                change-=5;
                ch++;
            }else if(change>=1){
                change-=1;
                ch++;
            }
        }
        System.out.println(ch);
    }
}