class Solution {
    int n, m;
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        this.n = n;
        this.m = m;
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++) {
            answer[i] = calc(startX, startY, balls[i][0], balls[i][1]);
        }
        
        return answer;
    }
    
    int calc(int sx, int sy, int ex, int ey) {
        int res = Integer.MAX_VALUE;
        
        int nx = -sx;
        int ny = sy;
        int rx = (int) Math.pow(nx - ex, 2);
        int ry = (int) Math.pow(ny - ey, 2);
        if(!(sy == ey && ex <= sx)) {
            res = Math.min(res, rx + ry);
        }
        
        nx = sx;
        ny = -sy;
        rx = (int) Math.pow(nx - ex, 2);
        ry = (int) Math.pow(ny - ey, 2);
        if(!(sx == ex && ey <= sy)) {
            res = Math.min(res, rx + ry);
        }
        
        nx = m + m - sx;
        ny = sy;
        rx = (int) Math.pow(nx - ex, 2);
        ry = (int) Math.pow(ny - ey, 2);
        if(!(sy == ey && sx <= ex)) {
            res = Math.min(res, rx + ry);
        }
        
        nx = sx;
        ny = n + n - sy;
        rx = (int) Math.pow(nx - ex, 2);
        ry = (int) Math.pow(ny - ey, 2);
        if(!(sx == ex && sy <= ey)) {
            res = Math.min(res, rx + ry);
        }
        
        return res;
    }
}