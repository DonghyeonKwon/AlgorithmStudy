import java.util.*;

class Solution {
    int n;
    int answer = Integer.MAX_VALUE;
    List<Edge>[] list;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        list = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] fare : fares) {
            int i = fare[0];
            int j = fare[1];
            int f = fare[2];
            
            list[i].add(new Edge(j, f));
            list[j].add(new Edge(i, f));
        }
        
        int[] startArr = dijkstra(s);
        int[] aArr = dijkstra(a);
        int[] bArr = dijkstra(b);
        
        for(int i = 1; i <= n; i++) {
            if(startArr[i] != Integer.MAX_VALUE
              && aArr[i] != Integer.MAX_VALUE
              && bArr[i] != Integer.MAX_VALUE) {
                answer = Math.min(answer, startArr[i] + aArr[i] + bArr[i]);
            }
        }
        
        return answer;
    }
    
    int[] dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] val = new int[n+1];
        Arrays.fill(val, Integer.MAX_VALUE);
        pq.add(new Edge(start, 0));
        val[start] = 0;
        int cnt = 1;
        
        while(!pq.isEmpty()) {
            Edge node = pq.poll();
            
            if(node.c > val[node.v]) continue;
            cnt++;
            if(cnt == n) break;
            
            for(Edge next : list[node.v]) {
                if(val[next.v] > val[node.v] + next.c) {
                    val[next.v] = val[node.v] + next.c;
                    pq.add(new Edge(next.v, val[next.v]));
                }
            }
        }
        
        return val;
    }
    
    class Edge implements Comparable<Edge> {
        int v;
        int c;
        
        Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }
}