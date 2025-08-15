package etc;

import java.io.*;

public class 너의평점은 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalUnit = 0.0;
        double totalScore = 0.0;
        for(int i = 0 ; i < 20; i ++){
            String[] input = br.readLine().split(" ");
            double unit = Double.parseDouble(input[1]);
            String score = input[2];
            if(score.equals("P")) continue;
            double point = 0.0;
            switch (score) {
                case "A+":
                    point = 4.5; break;
                case "A0":
                    point = 4.0; break;
                case "B+":
                    point = 3.5; break;
                case "B0":
                    point = 3.0; break;
                case "C+":
                    point = 2.5; break;
                case "C0":
                    point = 2.0; break;
                case "D+":
                    point = 1.5; break;
                case "D0":
                    point = 1.0; break;
                case "F":
                    point = 0.0; break;
            }
            totalUnit += unit;
            totalScore += unit * point;
        }

        double average = totalScore / totalUnit;
        System.out.printf("%.6f", average);
    }
}