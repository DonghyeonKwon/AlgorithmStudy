import java.util.*;

class Solution {
    int n, m;
    char[][] map;
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        map = new char[n+2][m+2];
        
        for(int i = 0; i < n+2; i++) {
            if(i == 0 || i == n+1) {
                for(int j = 0; j < m + 2; j++) {
                    map[i][j] = '.';
                }
                continue;
            }
            for(int j = 1; j < m + 1; j++) {
                map[i][j] = storage[i-1].charAt(j-1);
            }
            
            map[i][0] = map[i][m+1] = '.';
        }
        
        int answer = n * m;
        for(String request : requests) {
            if(request.length() == 1) {
                int k = bfs(request.charAt(0));
                answer -= k;
            } else {
                for(int i = 1; i <= n; i++) {
                    for(int j = 1; j <= m; j++) {
                        if(request.charAt(0) == map[i][j]) {
                            map[i][j] = '-';
                            answer--;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    int bfs(char c) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n+2][m+2];
        
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, -1, 0, 1};
        
        visited[0][0] = true;
        q.add(new int[]{0, 0});
        int cnt = 0;
        
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int y = pos[0];
            int x = pos[1];
            
            for(int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny < 0 || ny >= n+2 || nx < 0 || nx >= m+2) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] == c) {
                    visited[ny][nx] = true;
                    cnt++;
                } else if(map[ny][nx] == '-' || map[ny][nx] == '.') {
                    visited[ny][nx] = true;
                    q.add(new int[] {ny, nx});
                }
            }
        }
        
        for(int i = 0; i < n+2; i++) {
            for(int j = 0; j < m+2; j++) {
                if(visited[i][j]) map[i][j] = '.';
            }
        }
        
        return cnt;
    }
}