import java.util.*;

class Solution {
    public int solution(String[] words) {
        Trie root = new Trie();
        
        for(String str : words) {
            root.insert(str);
        }
        
        int answer = 0;
        
        for(String str : words) {
            answer += root.query(str);
        }
        
        return answer;
    }
}

class Trie {
    boolean isLeaf = true;
    Trie[] subTrie = new Trie[26];
    
    void insert(String str) {
        int index = 0;
        
        Trie trie;
        if(this.subTrie[charToInt(str.charAt(index))] == null) {
            trie = this.subTrie[charToInt(str.charAt(index))] = new Trie();
        } else {
            trie = this.subTrie[charToInt(str.charAt(index))];
            trie.isLeaf = false;
        }
        
        index++;
        
        while(index < str.length()) {
            int next = charToInt(str.charAt(index));
            if(trie.subTrie[next] == null) {
                trie.subTrie[next] = new Trie();
            } else {
                trie.subTrie[next].isLeaf = false;
            }
            
            trie = trie.subTrie[next];
            index++;
        }
    }
    
    int query(String str) {
        int idx = 0, cnt = 1;
        Trie trie = this.subTrie[charToInt(str.charAt(idx))];
        
        idx++;
        
        while(idx < str.length()) {
            int next = charToInt(str.charAt(idx));
            if(trie.isLeaf) break;
            trie = trie.subTrie[next];
            idx++;
            cnt++;
        }
        
        return cnt;
    }
    
    int charToInt(char c) {
        return c - 'a';
    }
}