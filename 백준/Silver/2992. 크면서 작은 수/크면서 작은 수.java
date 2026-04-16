import java.util.Scanner;

public class Main {
	static int n = 0;
	static int start = 0;
	static int res = 999999999;
	static char[] arr, combi;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr = sc.next().toCharArray();
		n = arr.length;
		combi = new char[n];
		visited = new boolean[n];
		start = Integer.parseInt(String.valueOf(arr));
		
		go(0);
		
		if(res == 999999999) {
			System.out.println(0);
		} else {
			System.out.println(res);
		}
	}
	
	static void go(int cnt) {
		if(cnt == n) {
			int a = Integer.parseInt(String.valueOf(combi));
			if(a > start && res > a) {
				res = a;
			}
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(visited[i]) continue;
			combi[cnt] = arr[i];
			visited[i] = true;
			go(cnt+1);
			visited[i] = false;
		}
	}
}
