import java.io.*;

public class Main {
	static char[] input;
	static boolean[] visited;
	static int n;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine().toCharArray();
		n = input.length;
		visited = new boolean[n];
		
		go(0, n-1);
		
		System.out.println(sb.toString());
	}
	
	static void go(int l, int r) {
		if(l > r) return;
		
		int idx = l;
		for(int i = l; i <= r; i++) {
			if(input[idx] > input[i]) {
				idx = i;
			}
		}
		
		visited[idx] = true;
		
		for(int i = 0; i < n; i++) {
			if(visited[i]) sb.append(input[i]);
		}
		sb.append('\n');
		
		go(idx+1, r);
		go(l, idx-1);
	}
}
