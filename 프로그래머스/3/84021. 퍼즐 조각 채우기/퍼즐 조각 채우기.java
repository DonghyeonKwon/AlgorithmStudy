import java.util.*;

class Solution {
    int n = 0, answer = 0;
    
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, -1, 0, 1};
    
    Queue<int[]> q = new ArrayDeque<>();
    List<List<int[]>> gameList = new ArrayList<>();
    static Comparator<int[]> com = (o1, o2) -> {
        if(o1[0] == o2[0]) return o1[1] - o2[1];
        return o1[0] - o2[0];
    };
    Queue<int[][]> blocks = new ArrayDeque<>();
    
    public int solution(int[][] game_board, int[][] table) {
        n = table.length;
        calcGameBoard(game_board);
        calcBlock(table);
        
        for(List<int[]> cur : gameList) {
            int size = blocks.size();
            for(int i = 0; i < size; i++) {
                int[][] block = blocks.poll();
                if(gameLogic(cur, block)) break;
                blocks.add(block);
            }
        }
        
        
        return answer;
    }
    
    boolean gameLogic(List<int[]> cur, int[][] block) {
        int cnt = 0;
        int m = block.length;
        while(cnt < 4) {
            block = locate(block);
            boolean first = true;
            boolean end = false;
            
            int size = 0;
            boolean[][] visited = new boolean[m][m];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < m; j++) {
                    if(block[i][j] == 0) continue;
                    
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                    List<int[]> temp = new ArrayList<>();
                    
                    while(!q.isEmpty()) {
                        int[] pos = q.poll();
                        for(int k = 0; k < 4; k++) {
                            int ny = pos[0] + dy[k];
                            int nx = pos[1] + dx[k];
                            
                            if(ny < 0 || ny >= m || nx < 0 || nx >= m) continue;
                            if(block[ny][nx] == 0 || visited[ny][nx]) continue;
                            size++;
                            visited[ny][nx] = true;
                            temp.add(new int[]{ny,nx});
                            q.add(new int[]{ny, nx});
                        }
                    }
                    
                    if(cur.size() != temp.size()) return false;
                    
                    temp.sort(com);
                    boolean isAnswer = true;
                    for(int k = 0; k < temp.size(); k++) {
                        int[] boardGet = cur.get(k);
                        int[] blockGet = temp.get(k);
                        
                        if(boardGet[0] != blockGet[0] - i || boardGet[1] != blockGet[1] - j) {
                            isAnswer = false;
                            break;
                        }
                    }
                    
                    if(isAnswer) {
                        answer += cur.size() + 1;
                        return true;
                    }
                    
                    first = false;
                    break;
                }
                
                if(!first) break;
            }
            
            cnt++;
        }
        
        return false;
    }
    
    int[][] locate(int[][] block) {
        int m = block.length;
        int[][] temp = new int[m][m];
        
        for(int i = 0; i < m; i++) {
            for(int j = m-1; j >= 0; j--) {
                temp[j][m - i - 1] = block[i][j];
            }
        }
        
        return temp;
    }
    
    void calcGameBoard(int[][] gb) {
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(gb[i][j] == 1 || visited[i][j]) continue;
                
                List<int[]> temp = new ArrayList<>();
                q.add(new int[]{i, j});
                visited[i][j] = true;
                
                while(!q.isEmpty()) {
                    int[] pos = q.poll();
                    
                    for(int k = 0; k < 4; k++) {
                        int ny = pos[0] + dy[k];
                        int nx = pos[1] + dx[k];
                        
                        if(check(ny, nx) || visited[ny][nx] || gb[ny][nx] == 1) continue;
                        
                        visited[ny][nx] = true;
                        temp.add(new int[]{ny - i, nx - j});
                        q.add(new int[]{ny, nx});
                    }
                }
                
                temp.sort(com);
                gameList.add(temp);
            }
        }
    }
    
    void calcBlock(int[][] block) {
        boolean[][] visited = new boolean[n][n];
        
        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < n; j++) {
                if(block[i][j] == 0 || visited[i][j]) continue;
                
                int minY = i;
                int minX = j;
                int maxY = i;
                int maxX = j;
                visited[i][j] = true;
                q.add(new int[]{i, j});
                
                while(!q.isEmpty()) {
                    int[] pos = q.poll();
                    
                    for(int k = 0; k < 4; k++) {
                        int ny = pos[0] + dy[k];
                        int nx = pos[1] + dx[k];
                        
                        if(check(ny, nx) || visited[ny][nx] || block[ny][nx] == 0) continue;
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                        
                        minY = Math.min(minY, ny);
                        maxY = Math.max(maxY, ny);
                        minX = Math.min(minX, nx);
                        maxX = Math.max(maxX, nx);
                    }
                }
                
                int len = Math.max(maxY - minY, maxX - minX) + 1;
                
                int[][] output = new int[len][len];
                for(int k = minY; k <= maxY; k++) {
                    for(int l = minX; l <= maxX; l++) {
                        output[k-minY][l-minX] = block[k][l]; 
                    }
                }
                blocks.add(output);
            }
        }
    }
    
    boolean check(int y, int x) {
        return y < 0 || y >= n || x < 0 || x >= n;
    }
}