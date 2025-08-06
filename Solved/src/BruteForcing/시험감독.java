package BruteForcing;

import java.io.*;
import java.util.*;

public class 시험감독 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());
        long[] students = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long[] supervisors = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long count =0;
        for(int i =0; i<students.length; i++){
            students[i] -= supervisors[0];
            count++;
        }

        for(int i =0; i<students.length; i++){
            if(students[i] <= 0) continue;
            if(students[i]/supervisors[1] > 0) count += students[i] / supervisors[1];
            if(students[i] % supervisors[1] > 0) count++;
        }

        System.out.println(count);
    }
}
