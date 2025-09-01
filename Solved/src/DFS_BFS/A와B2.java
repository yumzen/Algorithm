package DFS_BFS;

import java.io.*;

public class A와B2 {
    public static String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        for(int i = str.length() -1; i >= 0; i--){
            sb.setCharAt(str.length()-1-i, str.charAt(i));
        }
        return sb.toString();
    }

    public static boolean dfs(String S, String T, boolean possible){
        //System.out.println("S:" + S + " T:" +T);
        if(S.length() == T.length() && S.equals(T)) return true;
        if(S.length() >= T.length()) return false;
        int index = T.length() - 1;
        if(T.charAt(index) == 'A'){
            possible = possible || dfs(S, T.substring(0, index), possible);
        }
        if(T.charAt(0) == 'B') {
            possible = possible || dfs(S, reverse(T.substring(1, index+1)), possible);
        }
        return possible;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        System.out.println(dfs(S,T, false)? 1: 0);
    }
    /*
    public static String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        for(int i = str.length() -1; i >= 0; i--){
            sb.setCharAt(str.length()-1-i, str.charAt(i));
        }
        return sb.toString();
    }

    public static Boolean dfs(String S, String T){
        if(S.length() == T.length() && S.equals(T)) {
            return true;
        }
        if(S.length() >= T.length()) return false;
        return dfs(S + 'A', T) || dfs(reverse(S + 'B'), T);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        System.out.println(dfs(S, T) ? 1 : 0);
    }
     */
}
