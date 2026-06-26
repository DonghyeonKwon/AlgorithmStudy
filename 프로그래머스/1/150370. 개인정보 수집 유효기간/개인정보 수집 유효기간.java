import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int n = terms.length;
        
        String[] arr = today.split("\\.");
        Data now = new Data(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
        for(int i = 0; i < n; i++) {
            arr = terms[i].split(" ");
            map.put(arr[0].charAt(0), Integer.parseInt(arr[1]));
        }
        
        int len = privacies.length;
        for(int i = 0; i < len; i++) {
            arr = privacies[i].split(" ");
            String[] brr = arr[0].split("\\.");
            char term = arr[1].charAt(0);
            
            Data temp = new Data(Integer.parseInt(brr[0]), Integer.parseInt(brr[1]), Integer.parseInt(brr[2]));
            
            int cnt = map.get(term);
            
            temp.year += cnt / 12;
            cnt %= 12;
            temp.month += cnt;
            if(temp.month > 12) {
                temp.month -= 12;
                temp.year += 1;
            }
            
            temp.day -= 1;
            if(temp.day == 0) {
                temp.month -= 1;
                temp.day = 28;
                
                if(temp.month == 0) {
                    temp.month = 12;
                    temp.year -= 1;
                }
            }
            
            if(temp.getValue() < now.getValue()) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    class Data {
        int year;
        int month;
        int day;
        
        Data(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        
        int getValue() {
            return ((this.year - 2000) * 12 + this.month) * 28 + this.day;
        }
    }
}