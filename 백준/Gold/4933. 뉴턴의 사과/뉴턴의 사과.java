import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            String[] arr = br.readLine().split(" ");
            String[] brr = br.readLine().split(" ");

            if(arr.length != brr.length) {
                sb.append(false).append('\n');
                continue;
            }

            if(arr.length == 1) {
                sb.append(true).append('\n');
                continue;
            }

            Node root1 = postOrder(arr, arr.length - 2);
            Node root2 = postOrder(brr, brr.length - 2);

            sb.append(preOrder(root1, root2)).append('\n');
        }

        System.out.print(sb);

    }

    static boolean preOrder(Node n1, Node n2) {
        if(!n1.c.equals(n2.c)) {
            return false;
        }

        boolean flag = true;
        for(int i = 0; flag && i < 2; i++) {
            if(n1.arr[i] == null && n2.arr[i] == null) continue;
            if((n1.arr[i] == null && n2.arr[i] != null) ||
               (n1.arr[i] != null && n2.arr[i] == null)) {
//                System.out.printf("n1.arr[%d] %s\n", i, n1.arr[i] == null ? "null" : "not null");
//                System.out.printf("n2.arr[%d] %s\n", i, n2.arr[i] == null ? "null" : "not null");
                flag = false;
                continue;
            }
            flag = preOrder(n1.arr[i], n2.arr[i]);
        }

        return flag;
    }

    static Node postOrder(String[] arr, int idx) {
        if(arr[idx].equals("nil")) return null;

        Node node = new Node(arr[idx]);
        node.arr[1] = postOrder(arr, idx - 1);
        node.cnt += node.arr[1] == null ? 1 : node.arr[1].cnt;

        node.arr[0] = postOrder(arr, idx - node.cnt - 1);
        node.cnt += node.arr[0] == null ? 1 : node.arr[0].cnt;
        node.cnt += 1;

        if(node.arr[0] == null) {
            if(node.arr[1] != null) {
                node.arr[0] = node.arr[1];
                node.arr[1] = null;
            }
        } else {
            if(node.arr[1] != null) {
                if(node.arr[0].c.compareTo(node.arr[1].c) > 0) {
                    Node temp = node.arr[0];
                    node.arr[0] = node.arr[1];
                    node.arr[1] = temp;
                }
            }
        }
        return node;
    }

    static class Node {
        String c;
        int cnt = 0;
        Node[] arr;

        Node(String c) {
            this.c = c;
            this.arr = new Node[2];
        }
    }
}
