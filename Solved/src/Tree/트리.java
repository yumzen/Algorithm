package Tree;

import java.io.*;
import java.util.*;

public class 트리 {

    static List<Integer>[] children;
    static boolean[] removed;

    static void removeSubtree(int r) {
        removed[r] = true;
        for (int v : children[r]) {
            if (!removed[v]) removeSubtree(v);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] parent = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 1) children 인접 리스트 구성
        children = new ArrayList[N];
        for (int i = 0; i < N; i++) children[i] = new ArrayList<>();
        int root = -1;
        for (int i = 0; i < N; i++) {
            if (parent[i] == -1) root = i;
            else children[parent[i]].add(i);
        }

        // 2) 제거할 노드 입력 받고 서브트리 제거
        int r = Integer.parseInt(br.readLine().trim());
        removed = new boolean[N];
        removeSubtree(r);

        // 3) 리프 카운트: 살아있는 자식이 0개인 살아있는 노드
        int leafCount = 0;
        for (int u = 0; u < N; u++) {
            if (removed[u]) continue; // 잘려나간 노드 스킵
            int aliveChild = 0;
            for (int v : children[u]) {
                if (!removed[v]) {
                    aliveChild++;
                    break;
                }
            }
            if (aliveChild == 0) leafCount++;
        }

        System.out.println(leafCount);
    }
}