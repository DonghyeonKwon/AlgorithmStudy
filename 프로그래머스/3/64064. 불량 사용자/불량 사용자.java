import java.util.*;

class Solution {
    int n;
    String[] ban;
    Map<String, List<String>> map = new HashMap<>();
    Set<Set<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        n = banned_id.length;
        ban = banned_id;
        
        for(String ban : banned_id) {
            map.put(ban, new ArrayList<>());
            for(String user : user_id) {
                if(isSame(user, ban)) {
                    map.get(ban).add(user);
                }
            }
        }
        
        combi(0, new HashSet<String>());
        
        return result.size();
    }
    
    void combi(int depth, Set<String> set) {
        if(depth == n) {
            result.add(new HashSet<>(set));
            return;
        }
        
        for(String user : map.get(ban[depth])) {
            if(!set.contains(user)) {
                set.add(user);
                combi(depth + 1, set);
                set.remove(user);
            }
        }
    }
    
    boolean isSame(String user, String ban) {
        if(user.length() != ban.length()) return false;
        
        for(int i = 0; i < user.length(); i++) {
            if(ban.charAt(i) == '*') continue;
            if(user.charAt(i) != ban.charAt(i)) return false;
        }
        
        return true;
    }
}