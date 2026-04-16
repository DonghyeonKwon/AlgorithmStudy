import java.util.Scanner;

public class Main {
	static Pair[] pairs;
	static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		pairs = new Pair[n];
		for(int i = 0; i < n ; i++) {
			int s = sc.nextInt();
			int b = sc.nextInt();
			pairs[i] = new Pair(s, b);
		}
		
		subset(0, 0, 1, 0, n);
		
		System.out.println(res);
	}
	
	static void subset(int ecnt, int idx, int totalS, int totalB, int n) {
		if(idx == n) {
			if(ecnt > 0 && res > Math.abs(totalS - totalB)) {
				res = Math.abs(totalS - totalB);
			}
			return;
		}
		
		subset(ecnt, idx+1, totalS, totalB, n);
		subset(ecnt | (1 << idx), idx+1, totalS * pairs[idx].s, totalB + pairs[idx].b, n);
	}
	
	static class Pair{
		int s, b;
		Pair(int s, int b){
			this.s = s;
			this.b = b;
		}
	}
}
