class Solution {
    int n, m;
    int[][] board;
    int[] dy = { -1, 0, 1, 0 };
    int[] dx = { 0, -1, 0, 1 };
    int answer = 0;
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        this.n = board.length;
        this.m = board[0].length;
        return go(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
    
    int go(int py, int px, int oy, int ox) {
        if(board[py][px] == 0) {
            return 0;
        }
        
        int ret = 0;
        for(int i = 0; i < 4; i++) {
            int ny = py + dy[i];
            int nx = px + dx[i];
            
            if(ny < 0 || ny >= n || nx < 0 || nx >= m || board[ny][nx] == 0) continue;
            
            board[py][px] = 0;
            int val = go(oy, ox, ny, nx) + 1;
            board[py][px] = 1;
            
            if(ret % 2 == 0 && val % 2 == 1) {
                ret = val;
            } else if(ret % 2 == 0 && val % 2 == 0) {
                ret = ret > val ? ret : val;
            } else if(ret % 2 == 1 && val % 2 == 1) {
                ret = ret < val ? ret : val;
            }
        }        
        
        return ret;
    }
}