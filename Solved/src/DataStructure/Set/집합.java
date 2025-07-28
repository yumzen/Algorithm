package DataStructure.Set;

import java.io.*;
import java.util.*;

public class 집합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        Set<Integer> allSet = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            allSet.add(i);
        }

        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()) num = Integer.parseInt(st.nextToken());
            switch(text){
                case("add"):
                    set.add(num);
                    break;
                case("remove"):
                    set.remove(num);
                    break;
                case("check"):
                    bw.write(set.contains(num) ? 1 + "\n" : 0 + "\n");
                    break;
                case("toggle"):
                    if(set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
                case("all"):
                    set.clear();
                    set.addAll(allSet);
                    break;
                case("empty"):
                    set.clear();
                    break;
            }
        }
        bw.flush();
    }
}
