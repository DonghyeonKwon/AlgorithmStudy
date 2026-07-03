class Solution {
    int answer = 0, n, m;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, -1, 0, 1};
    int[][] map, visited;
    
    int up = 0, left = 1, down = 2, right = 3;
    int[][] placeableRail = {
        {2, 3, 6, 7},
        {1, 3, 5, 6},
        {2, 3, 4, 5},
        {1, 3, 4, 7}
    };
    
    public int solution(int[][] grid) {
        map = grid;
        n = map.length;
        m = map[0].length;
        visited = new int[n][m];
        
        visited[0][0] = 1;
        visited[n-1][m-1] = 1;
        go(0, 1, right);
        
        return answer;
    }
    
    void go(int y, int x, int d) {
        if(outOfBound(y, x) || isBlocked(y, x)) return;
        
        if(y == n-1 && x == m-1) {
            if(checkMap() && isValidDirection(y, x, d)) { 
                answer++;
            }
            return;
        }
        
        visited[y][x]++;
        
        if(isEmpty(y, x)) {
            for(int rail : placeableRail[d]) {
                map[y][x] = rail;
                int[] next = getNextPosition(y, x, d);
                go(next[0], next[1], next[2]);
            }
            map[y][x] = 0;
        } else {
            if(isValidDirection(y, x, d)) {
                int[] next = getNextPosition(y, x, d);
                go(next[0], next[1], next[2]);
            }
        }
        
        visited[y][x]--;
    }
    
    boolean isValidDirection(int y, int x, int d) {
        switch(map[y][x]) {
            case 1:
                return d == left || d == right;
            case 2:
                return d == up || d == down;
            case 3:
                return true;
            case 4:
                return d == right || d == down;
            case 5:
                return d == left || d == down;
            case 6:
                return d == up || d == left;
            case 7:
                return d == up || d == right;
        }
        
        return false;
    }
    
    int[] getNextPosition(int y, int x, int d) {
        int[] next = new int[3];
        
        switch(map[y][x]) {
            case 1, 2, 3: break;
            case 4:
                d = d == right ? up : left;
                break;
            case 5:
                d = d == left ? up : right;
                break;
            case 6:
                d = d == left ? down : right;
                break;
            case 7:
                d = d == right ? down : left;
                break;
        }
        
        next[0] = y + dy[d];
        next[1] = x + dx[d];
        next[2] = d;
        
        return next;
    }
    
    boolean checkMap() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 3 && visited[i][j] != 2) return false;
                
                if(map[i][j] >= 1 && map[i][j] <= 7 && visited[i][j] < 1) return false;
            }
        }
        
        return true;
    }
    
    boolean outOfBound(int y, int x) {
        return (y < 0 || y >= n || x < 0 || x >= m);
    }
    
    boolean isBlocked(int y, int x) {
        return map[y][x] == -1;
    }
    
    boolean isEmpty(int y, int x) {
        return map[y][x] == 0;
    }
}