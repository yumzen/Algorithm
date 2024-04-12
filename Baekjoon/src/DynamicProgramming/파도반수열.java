package DynamicProgramming;
// 9461 파도반 수열
import java.io.*;

public class 파도반수열 {
    static long[] seq = new long[101];
    public  static long sequence(int n){
        if(seq[n] == 0 && n>3) {
            seq[n] = sequence(n - 2) + sequence(n - 3);
        }
        return seq[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        seq[0] = 0;
        seq[1] = 1;
        seq[2] = 1;
        seq[3] = 1;

        for(int i = 0 ; i< T; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(sequence(n));
        }
    }
}
