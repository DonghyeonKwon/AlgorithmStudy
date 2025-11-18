import java.util.*;

class Solution {
    int[][] point;
    public int solution(int[][] points, int[][] routes) {
        int len = routes.length;
        point = points;
        
        Queue<Robot> queue = new ArrayDeque<>();
        for(int i = 0; i < len; i++) {
            queue.add(new Robot(routes[i]));
        }
        
        int answer = 0;
        List<Robot> temp = new ArrayList<>();
        int[][] map = new int[101][101];
        while(!queue.isEmpty()) {
            Robot r = queue.poll();
            map[r.nowY][r.nowX]++;
            
            if(r.check()) {
                temp.add(r);
                r.move();
            } else {
                if(r.isNext()) {
                    temp.add(r);
                    r.move();
                }
            }
            
            if(queue.isEmpty()) {
                for(int i = 1; i <= 100; i++) {
                    for(int j = 1; j <= 100; j++) {
                        if(map[i][j] > 1) answer++;
                    }
                }
                
                map = new int[101][101];
                queue.addAll(temp);
                temp.clear();
            }
        }
        
        return answer;
    }
    
    class Robot {
        int idx;
        int nowY, nowX;
        int[] route;
        int dy, dx;

        Robot(int[] route) {
            this.idx = 1;
            this.route = route;
            this.nowY = point[route[0] - 1][0];
            this.nowX = point[route[0] - 1][1];
            this.dy = nowY - point[route[1] - 1][0];
            this.dx = nowX - point[route[1] - 1][1];
        }

        boolean isNext() {
            this.idx++;
            if(this.idx < this.route.length) {
                this.dy = this.nowY - point[route[idx] - 1][0];
                this.dx = this.nowX - point[route[idx] - 1][1];
                return true;
            }
            return false;
        }
        
        boolean check() {
            return this.dy != 0 || this.dx != 0;
        }
        
        void move() {
            if(dy != 0) {
                if(dy > 0) {
                    nowY--;
                    dy--; 
                } else {
                    nowY++;
                    dy++;
                }
            } else if(dx != 0) {
                if(dx > 0) {
                    nowX--;
                    dx--;
                } else {
                    nowX++;
                    dx++;
                }
            }
        }
    }
}