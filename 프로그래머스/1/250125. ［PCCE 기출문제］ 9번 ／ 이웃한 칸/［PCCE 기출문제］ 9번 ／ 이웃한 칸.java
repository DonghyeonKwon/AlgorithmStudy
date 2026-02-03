import java.util.*;

class Solution {
    int n;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, -1, 0, 1};
    
    public int solution(String[][] board, int h, int w) {
        n = board.length;
        
        int answer = 0;
            
        for(int i = 0; i < 4; i++) {
            int ny = h + dy[i];
            int nx = w + dx[i];

            if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
            if(!board[ny][nx].equals(board[h][w])) continue;
            answer++;
        }
        
        return answer;
    }
}