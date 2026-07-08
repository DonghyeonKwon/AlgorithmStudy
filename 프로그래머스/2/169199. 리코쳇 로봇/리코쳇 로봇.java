import java.util.*;

class Solution {
    int ry, rx, gy, gx, n, m, answer = -1;
    char[][] map;
    int[][] visited;
    
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, -1, 0, 1};
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        visited = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);
                visited[i][j] = Integer.MAX_VALUE;
                
                if(map[i][j] == 'R') {
                    ry = i;
                    rx = j;
                } else if(map[i][j] == 'G') {
                    gy = i;
                    gx = j;
                }
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < 4; i++) {
            int ny = gy + dy[i];
            int nx = gx + dx[i];
            
            if(ny < 0|| ny >= n || nx < 0 || nx >= m || map[ny][nx] == 'D') cnt++; 
        }
        
        if(cnt == 0 || cnt == 4) return -1;
        
        bfs(ry, rx);
        
        return answer;
    }
    
    void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[y][x] = 0;
        q.add(new int[]{y, x, 0});
        
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            
            if(pos[0] == gy && pos[1] == gx) {
                if(answer == -1) {
                    answer = pos[2];
                    continue;
                }
                answer = Math.min(answer, pos[2]);
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];
                
                int cnt = 0;
                while(!(ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == 'D')) {
                    cnt++;
                    ny += dy[i];
                    nx += dx[i];
                }
                
                ny -= dy[i];
                nx -= dx[i];
                
                if(cnt == 0) continue;
                if(visited[ny][nx] < pos[2] + 1) continue;
                
                visited[ny][nx] = pos[2] + 1;
                q.add(new int[]{ny, nx, visited[ny][nx]});
                
            }
        }
    }
}