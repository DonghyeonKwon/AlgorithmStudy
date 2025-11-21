class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int attackIdx = 0;
        int maxHealth = health;
        
        int time = 0, successTime = 0;
        while(health > 0 && attackIdx < attacks.length) {
            time++;
            
            if(attacks[attackIdx][0] == time) {
                health -= attacks[attackIdx][1];
                successTime = 0;
                attackIdx++;
            } else {
                health += bandage[1];
                successTime++;
                if(successTime == bandage[0]) {
                    successTime = 0;
                    health += bandage[2];
                }
                if(health > maxHealth) health = maxHealth;
            }
        }
        
        int answer = health <= 0 ? -1 : health;
        return answer;
    }
}