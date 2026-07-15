import java.util.*;

class Solution {
    int n, INF = 100_000_001, MS = 10001;
    List<Node> list = new ArrayList<>(); 
    int[][] dp;
    
    public int solution(int k, int[] num, int[][] links) {
        n = num.length;
        
        int sum = 0;
        boolean[] check = new boolean[n];
        for(int i = 0; i < n; i++) {
            int left = links[i][0];
            int right = links[i][1];
            if(left != -1) check[left] = true;
            if(right != -1) check[right] = true;
            list.add(new Node(num[i], left, right));
            sum += num[i];
        }
        
        int root = -1;
        for(int i = 0; i < n; i++) {
            if(!check[i]) root = i;
        }
        
        int left = sum / k;
        int right = sum;
        if(left == right) return right;
        while(left < right) {
            int mid = (left + right) / 2;
            dp = new int[n][2];
            search(root, mid);
            
            if(dp[root][0] <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right;

    }
    
    void search(int num, int w) {
        Node node = list.get(num);
        int data = node.data;
        int l = node.left;
        int r = node.right;
        
        if(l != -1) search(l, w);
        if(r != -1) search(r, w);
        
        if(l == -1 && r == -1) {
            if(data <= w) {
                dp[num][0] = 1;
                dp[num][1] = data;
            } else {
                dp[num][0] = MS;
                dp[num][1] = INF;
            }
        } else if(l != -1 && r != -1) {
            if(data + dp[l][1] + dp[r][1] <= w) {
                dp[num][0] = dp[l][0] + dp[r][0] - 1;
                dp[num][1] = dp[l][1] + dp[r][1] + data;
            } else if(data + Math.min(dp[l][1], dp[r][1]) <= w) {
                dp[num][0] = dp[l][0] + dp[r][0];
                dp[num][1] = data + Math.min(dp[l][1], dp[r][1]);
            } else if(data <= w) {
                dp[num][0] = dp[l][0] + dp[r][0] + 1;
                dp[num][1] = data;
            } else {
                dp[num][0] = MS;
                dp[num][1] = INF;
            }
        } else {
            if(r == -1) {
                if(data + dp[l][1] <= w) {
                    dp[num][0] = dp[l][0];
                    dp[num][1] = data + dp[l][1];
                } else if(data <= w) {
                    dp[num][0] = dp[l][0] + 1;
                    dp[num][1] = data;
                } else {
                    dp[num][0] = MS;
                    dp[num][1] = INF;
                }
            }
            if(l == -1) {
                if(data + dp[r][1] <= w) {
                    dp[num][0] = dp[r][0];
                    dp[num][1] = data + dp[r][1];
                } else if(data <= w) {
                    dp[num][0] = dp[r][0] + 1;
                    dp[num][1] = data;
                } else {
                    dp[num][0] = MS;
                    dp[num][1] = INF;
                }
            }
        }
    }
    
    class Node {
        int data;
        int left, right;
        
        Node(int data, int left, int right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
            
    }
}