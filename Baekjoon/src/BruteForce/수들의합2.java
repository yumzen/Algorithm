package BruteForce;
//2003 수들의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        //StringTokenizer 객체를 사용하여 N과 M에 공백을 기준으로 나누어 저장
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String numbers = br.readLine();
        StringTokenizer ns = new StringTokenizer(numbers);
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(ns.nextToken());
        }

        int count = 0;
        int num;
        for(int i =0; i<N; i++){
            num = nums[i];
            if(nums[i]==M) count++;
            else if(nums[i]<M){
                for(int j = i+1; j<N; j++){
                    num += nums[j];
                    if(num == M){
                        count ++;
                        break;
                    }else if(num>M) break;
                }
            }
        }
        System.out.println(count);
    }
}
