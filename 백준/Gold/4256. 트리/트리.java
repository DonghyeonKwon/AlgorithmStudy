import java.io.*;
import java.util.*;

public class Main {
    static int n, idx = 0;
    static int[] preorder;
    static int[] inorder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            n = Integer.parseInt(br.readLine());

            preorder = new int[n];
            inorder = new int[n];
            idx = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                preorder[i] = Integer.parseInt(st.nextToken());
                inorder[i] = Integer.parseInt(st2.nextToken());
            }

            Node tree = new Node(preorder[idx]);

            for(int i = 0; i < n; i++) {
                if(idx < n && preorder[idx] == inorder[i]) {
                    idx++;
                    tree.left = find(0, i-1);
                    tree.right = find(i+1, n-1);
                }
            }

            tree.postorder();
            System.out.println();
        }
    }

    static Node find(int start, int end) {
        if(start > end) return null;
        
        Node node = new Node(preorder[idx]);

        for(int i = start; i <= end; i++) {
            if(preorder[idx] == inorder[i]) {
                idx++;
                node.left = find(start, i - 1);
                node.right = find(i + 1, end);
                break;
            }
        }

        return node;
    }

    static class Node {
        int num;
        Node left;
        Node right;

        Node(int num) {
            this.num = num;
        }

        public void postorder() {
            if(this.left != null) this.left.postorder();
            if(this.right != null) this.right.postorder();
            System.out.print(this.num + " ");
        }
    }
}
