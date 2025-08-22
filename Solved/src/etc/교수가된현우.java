package etc;

import java.io.*;

public class 교수가된현우 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] str = new String[T];
        for(int i = 0; i < T; i++){
            str[i] = br.readLine();
        }

        for(int i = 0 ; i < T; i++){
            int num = Integer.parseInt(str[i]);
            int two = 0;
            int five = 0;
            for( int j = 2; j <= num ; j *= 2){
                two +=num/j;
            }
            for( int j = 5; j <= num ; j *= 5){
                five +=num/j;
            }
            System.out.println(Math.min(two, five));
        }
    }
}
