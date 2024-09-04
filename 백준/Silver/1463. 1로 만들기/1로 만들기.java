import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N == 1) {
            System.out.println(0);
            return;
        }
        
        boolean[] visited = new boolean[N+1];
        ArrayDeque<int[]> pq = new ArrayDeque<>();
        pq.add(new int[] {N, 0});
        visited[N] = true;
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            
            if (node[0] == 1) {
                System.out.println(node[1]);
                return;
            }
            
            if (node[0]%2==0 && !visited[node[0]/2]) {
                visited[node[0]/2] = true;
                pq.add(new int[] {node[0]/2, node[1]+1});
            }
            
            if (node[0]%3==0 && !visited[node[0]/3]) {
                visited[node[0]/3] = true;
                pq.add(new int[] {node[0]/3, node[1]+1});
            }
            
            if (!visited[node[0]-1]) {
                visited[node[0]-1] = true;
                pq.add(new int[] {node[0]-1, node[1]+1});
            }
        }
    }

}