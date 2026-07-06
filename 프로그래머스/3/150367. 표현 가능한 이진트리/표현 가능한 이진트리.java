class Solution {
    
    public int[] solution(long[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++) {
            String binaryNum = Long.toBinaryString(numbers[i]);
            
            if(!binaryNum.contains("0")) {
                answer[i] = 1;
                continue;
            }
            
            if(binaryNum.length() == 1) {
                if(numbers[i] == 0) {
                    answer[i] = 0;
                    continue;
                }
            } else {
                binaryNum = makeTree(binaryNum);
            }
            
            answer[i] = isTree(binaryNum, 0, binaryNum.length() - 1) ? 0 : 1;
        }
        
        return answer;
    }
    
    boolean isTree(String value, int start, int end) {
        if(start > end || start == end) return false;
        
        int root = (start + end) / 2;
        
        if(value.charAt(root) == '0') {
            for(int i = start; i <= end; i++) {
                if(value.charAt(i) == '1') return true;
            }
            
            return false;
        }
        
        return isTree(value, start, root - 1) || isTree(value, root + 1, end);
    }
    
    String makeTree(String binaryNum) {
        int len = 1;
        
        while(binaryNum.length() > len) {
            len = len * 2 + 1;
        }
        
        int zeroCnt = len - binaryNum.length();
        return "0".repeat(zeroCnt) + binaryNum;
    }
    
}