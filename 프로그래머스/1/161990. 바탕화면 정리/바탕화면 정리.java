class Solution {
    public int[] solution(String[] wallpaper) {
        int h = wallpaper.length;
        int w = wallpaper[0].length();
        
        int sy = h, sx = w, ey = 0, ex = 0;
        
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    sy = Math.min(sy, i);
                    sx = Math.min(sx, j);
                    ey = Math.max(ey, i);
                    ex = Math.max(ex, j);
                }
            }
        }
        
        return new int[]{sy, sx, ey+1, ex+1};
    }
}