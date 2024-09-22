import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int psum[] = new int[n+1];
		for(int i = 1; i <= n; i++) {
			psum[i] = sc.nextInt() + psum[i-1];
		}
		
		int l = 0, r = 1;
		int res = 0;
		
		while(r <= n) {
			int sum = psum[r] - psum[l];
			
			if(sum >= m) {
				if(res == 0) res = r - l;
				else res = Math.min(r-l, res);
				l++;
				continue;
			}
			
			if(sum < m) {
				r++;
				continue;
			}
		}
		
		System.out.println(res);
	}
}