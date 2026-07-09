import java.util.*;

class Solution {
    int n, m;
    char[][] map;
    
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, -1, 0, 1};
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        map = new char[n][m];
        int sy = 0, sx = 0, ey = 0, ex = 0, ly = 0, lx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') {
                    sy = i;
                    sx = j;
                } else if(map[i][j] == 'L') {
                    ly = i;
                    lx = j;
                } else if(map[i][j] == 'E') {
                    ey = i;
                    ex = j;
                }
            }
        }
        
        int answer = 0;
        int res1 = bfs(sy, sx, ly, lx);
        if(res1 == -1) return -1;
        int res2 = bfs(ly, lx, ey, ex);
        if(res2 == -1) return -1;
        
        return res1 + res2;
    }
    
    int bfs(int y, int x, int ey, int ex) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        
        q.add(new int[]{y, x, 0});
        visited[y][x] = 0;
        
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            
            if(pos[0] == ey && pos[1] == ex) {
                return pos[2];
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];
                
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(map[ny][nx] == 'X') continue;
                if(visited[ny][nx] <= pos[2] + 1) continue;
                
                visited[ny][nx] = pos[2] + 1;
                q.add(new int[]{ny, nx, pos[2] + 1});
            }
        }
        
        return -1;
    }
}