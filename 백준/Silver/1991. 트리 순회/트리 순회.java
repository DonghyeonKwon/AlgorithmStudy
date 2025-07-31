import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Node root = new Node('A');

        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            char main = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            Node node = search(root, main);

            if(left != '.') {
                node.left = new Node(left);
            }
            if(right != '.') {
                node.right = new Node(right);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(preorder(root)).append('\n').append(inorder(root)).append('\n').append(postorder(root));

        System.out.print(sb);

    }

    static String postorder(Node node) {
        String temp = "";

        if(node.left != null) temp += postorder(node.left);
        if(node.right != null) temp += postorder(node.right);
        temp += node.c;

        return temp;
    }

    static String inorder(Node node) {
        String temp = "";

        if(node.left != null) temp += inorder(node.left);
        temp += node.c;
        if(node.right != null) temp += inorder(node.right);

        return temp;
    }

    static String preorder(Node node) {
        String temp = "";

        temp += node.c;
        if(node.left != null) temp += preorder(node.left);
        if(node.right != null) temp += preorder(node.right);

        return temp;
    }

    static Node search(Node node, char c) {
        if(node.c == c) return node;

        Node tmp = null;
        if(tmp == null && node.left != null) tmp = search(node.left, c);
        if(tmp == null && node.right != null) tmp = search(node.right, c);

        return tmp;
    }

    static class Node {
        char c;
        Node left;
        Node right;

        Node (char c) {
            this.c = c;
            this.left = null;
            this.right = null;
        }
    }
}
