import java.util.*;

class Solution {
    int n, m;
    int[][] map;
    boolean[][] visited;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, -1, 0, 1};
    int[] arr;
    
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        map = land;
        arr = new int[m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0 || visited[i][j]) continue;
                bfs(i, j);
            }
        }
        
        int answer = 0;
        for(int i = 0; i < m; i++) {
            answer = Math.max(answer, arr[i]);
        }
        return answer;
    }
    
    void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        int minX = x;
        int maxX = x;
        int cnt = 1;
        visited[y][x] = true;
        q.add(new int[]{y, x});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] == 0) continue;
                cnt++;
                minX = Math.min(minX, nx);
                maxX = Math.max(maxX, nx);
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }
        
        for(int i = minX; i <= maxX; i++) {
            arr[i] += cnt;
        }
    }
}