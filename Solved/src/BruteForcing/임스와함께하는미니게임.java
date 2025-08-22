package BruteForcing;

import java.io.*;
import java.util.*;

public class 임스와함께하는미니게임 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        String game = input[1];
        int maxMem = 2;
        switch (game){
            case "Y": maxMem = 2; break;
            case "F": maxMem = 3; break;
            case "O": maxMem = 4; break;
        }
        HashSet<String> player = new HashSet<>();
        for(int i = 0 ; i< n; i++){
            player.add(br.readLine());
        }
        System.out.println(player.size()/(maxMem-1));
    }
}
