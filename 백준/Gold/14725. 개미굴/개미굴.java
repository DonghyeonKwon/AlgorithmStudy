import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =  Integer.parseInt(br.readLine());
		
		Trie root = new Trie();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			
			Trie temp = root;
			for(int j = 0; j < m; j++) {
				String str = st.nextToken();
				
				if(temp.map.get(str) == null) {
					temp.map.put(str, new Trie());
				}
				temp = temp.map.get(str);
			}
		}
		
		round(root.map.entrySet(), 0);
		
		System.out.println(sb);
	}
	
	static void round(Set<Entry<String, Trie>> entrySet, int cnt) {
		if(entrySet.size() == 0) {
			return;
		}
		
		for(Entry<String, Trie> entry : entrySet) {
			for(int i = 0; i < cnt; i++)
				sb.append("--");
			sb.append(entry.getKey()).append("\n");
			round(entry.getValue().map.entrySet(), cnt+1);
		}
	}
	
	static class Trie{
		TreeMap<String, Trie> map;
		Trie(){
			this.map = new TreeMap<>();
		}
	}
}