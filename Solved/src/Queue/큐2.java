package Queue;

import java.io.*;
import java.util.*;

public class 큐2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i =0; i <N; i++){
            String str = br.readLine();
            if(str.startsWith("push")){
                String[] input = str.split(" ");
                queue.add(Integer.parseInt(input[1]));
            } else if (str.startsWith("pop")){
               bw.write(queue.isEmpty() ? "-1\n" : String.valueOf(queue.poll()) + "\n");
            } else if (str.startsWith("size")){
                bw.write(queue.size() + "\n");
            } else if (str.startsWith("empty")){
                bw.write(queue.isEmpty() ? "1\n" : "0\n");
            } else if (str.startsWith("front")){
                bw.write(queue.isEmpty() ? "-1\n" : String.valueOf(queue.peek())+ "\n");
            } else if (str.startsWith("back")){
                bw.write(queue.isEmpty() ? "-1\n" : String.valueOf(queue.peekLast())+ "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
