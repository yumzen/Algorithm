package DynamicProgramming;

import java.io.*;

public class 돌 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write((N % 2 == 1) ? "SK" : "CY");
        bw.flush();
        bw.close();
        br.close();
    }
}