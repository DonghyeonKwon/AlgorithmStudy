import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String str : callings) {
            int idx = map.get(str);
            String temp = players[idx];
            players[idx] = players[idx-1];
            players[idx-1] = temp;
            
            map.put(players[idx-1], idx-1);
            map.put(players[idx], idx);
        }
        
        return players;
    }
}