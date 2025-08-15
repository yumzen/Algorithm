package Sorting;

import java.io.*;

public class 음계 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        boolean isAscending = true;
        boolean isDescending = true;
        for(int i = 0 ; i < 8; i++){
            if (input[i].equals(String.valueOf(i+1))){
                isDescending = false;
            } else if (input[i].equals(String.valueOf(8-i))) {
                isAscending = false;
            } else {
                isAscending = false;
                isDescending = false;
                break;
            }
        }
        System.out.println(isAscending ? "ascending" : isDescending ? "descending" : "mixed");
    }
}
