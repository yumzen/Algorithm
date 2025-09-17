package HackerRank_1WeekPreparationKits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class plusminuszero {
    class Result {

        /*
         * Complete the 'plusMinus' function below.
         *
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static void plusMinus(List<Integer> arr) {
            // Write your code here
            int plus = 0, minus = 0, zero = 0;
            int n = arr.size();
            for(int i = 0; i < n; i++){
                if(arr.get(i) < 0) minus++;
                else if(arr.get(i) == 0) zero++;
                else plus++;
            }
            double p = (double) plus / n;
            double m = (double) minus / n;
            double z = (double) zero / n;
            System.out.printf("%.6f%n", p);
            System.out.printf("%.6f%n", m);
            System.out.printf("%.6f%n", z);
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            Result.plusMinus(arr);

            bufferedReader.close();
        }
    }

}
