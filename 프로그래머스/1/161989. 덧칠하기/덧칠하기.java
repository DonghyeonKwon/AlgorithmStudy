class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        boolean[] visited = new boolean[n];
        for(int i = 0; i < section.length; i++) {
            visited[section[i] - 1] = true;
        }
        
        for(int area : section) {
            if(!visited[area - 1]) continue;
            
            for(int i = area - 1; i < area + m - 1 && i < n; i++) {
                visited[i] = false;
            }
            answer++;
        }
        
        return answer;
    }
}