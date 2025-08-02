import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = null;

        while(true) {
            String input = br.readLine();
            if(input == null || "".equals(input)) break;

            if(root == null) root = new Node(Integer.parseInt(input));
            else root.insert(Integer.parseInt(input));
        }

        go(root);

        System.out.print(sb);
    }

    static void go(Node node) {
        if(node.left != null) go(node.left);
        if(node.right != null) go(node.right);
        sb.append(node.num + "\n");
    }

    static class Node{
        int num;
        Node left;
        Node right;

        Node(int num) {
            this.num = num;
        }

        void insert(int num) {
            if(this.num > num) {
                if(this.left == null) {
                    this.left = new Node(num);
                    return;
                }

                this.left.insert(num);
            } else if(this.num < num) {
                if(this.right == null) {
                    this.right = new Node(num);
                    return;
                }

                this.right.insert(num);
            }
        }
    }
}
