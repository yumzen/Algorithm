package Tree;

import java.io.*;

public class 이진검색트리 {

    static class Node {
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
        }
        void insert(int n){
            if(n<this.val){
                if(this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if(this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    public static void postorder(Node cur){
        if(cur == null) return;
        postorder(cur.left);
        postorder(cur.right);
        System.out.println(cur.val);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String s = "";
        while((s = br.readLine()) != null && !s.isBlank()){
            root.insert(Integer.parseInt(s));
        }
        postorder(root);
    }
}
