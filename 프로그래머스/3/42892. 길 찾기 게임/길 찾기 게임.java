import java.util.*;

class Solution {
    List<Node> tree = new ArrayList<>();
    int len;
    int idx = 0;
    int[][] answer;
    
    public int[][] solution(int[][] nodeinfo) {
        len = nodeinfo.length;
    
        for(int i = 0 ; i < len; i++) {
            tree.add(new Node(nodeinfo[i][1], nodeinfo[i][0], i + 1));
        }
        
        Collections.sort(tree);
        Node root = tree.get(0);
        for(int i = 1; i < len; i++) {
            link(root, tree.get(i));
        }
        
        answer = new int[2][len];
        preorder(root);
        idx = 0;
        postorder(root);
        
        return answer;
    }
    
    void link(Node node, Node child) {
        if(node.x > child.x) {
            if(node.left == null) {
                node.left = child;
                return;
            }
            link(node.left, child);
        } else {
            if(node.right == null) {
                node.right = child;
                return;
            }
            link(node.right, child);
        }
    }
    
    void preorder(Node node) {
        if(node != null) {
            answer[0][idx++] = node.idx;
            preorder(node.left);
            preorder(node.right);
        }
    }
    
    void postorder(Node node) {
        if(node != null) {
            postorder(node.left);
            postorder(node.right);
            answer[1][idx++] = node.idx;
        }
    }
}

class Node implements Comparable<Node> {
    int y, x, idx;
    Node left = null;
    Node right = null;
    
    Node(int y, int x, int idx) {
        this.y = y;
        this.x = x;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Node o) {
        return o.y - this.y;
    }
}