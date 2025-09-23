package Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 트리순회 {
    public static void preorder(int[] left, int[] right, int node) {
        if (node == -1) return; // 자식 없으면 종료
        System.out.print((char)('A' + node)); // 루트 출력
        preorder(left, right, left[node]);    // 왼쪽 자식
        preorder(left, right, right[node]);   // 오른쪽 자식
    }
    public static void inorder(int[] left, int[] right, int node) {
        if (node == -1) return; // 자식 없으면 종료
        inorder(left, right, left[node]);    // 왼쪽 자식
        System.out.print((char)('A' + node)); // 루트 출력
        inorder(left, right, right[node]);   // 오른쪽 자식
    }
    public static void postorder(int[] left, int[] right, int node) {
        if (node == -1) return; // 자식 없으면 종료
        postorder(left, right, left[node]);    // 왼쪽 자식
        postorder(left, right, right[node]);   // 오른쪽 자식
        System.out.print((char)('A' + node)); // 루트 출력
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        int[] left = new int[N];
        int[] right = new int[N];
        Arrays.fill(left,-1);
        Arrays.fill(right, -1);
        for(int i = 0; i <N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = st.nextToken().charAt(0) - 'A';
            char lc = st.nextToken().charAt(0);
            char rc = st.nextToken().charAt(0);
            if(lc != '.') left[p] = lc - 'A';
            if(rc != '.') right[p] = rc - 'A';
        }
        preorder(left, right, 0);
        System.out.println();
        inorder(left, right, 0);
        System.out.println();
        postorder(left, right, 0);
    }
}
