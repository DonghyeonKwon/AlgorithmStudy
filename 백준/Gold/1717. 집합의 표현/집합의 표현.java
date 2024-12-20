import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] parent;
	
	static int find(int k) {
		if(parent[k] == k) return k;
		return parent[k] = find(parent[k]);
	}
	
	static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA != parentB) {
			parent[parentB] = parentA;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = sc.nextInt();
		m = sc.nextInt();
		
		parent = new int[n+1];
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		while(m --> 0) {
			int cmd = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(cmd == 0) {
				union(a ,b);
			} else {
				if(find(a) == find(b)) {
					sb.append("yes\n");
				} else {
					sb.append("no\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
