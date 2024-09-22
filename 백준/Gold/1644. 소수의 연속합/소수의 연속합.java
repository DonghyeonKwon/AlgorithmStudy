import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		boolean[] flag = new boolean[n+1];
		int m = (int)Math.sqrt(n);
		for(int i = 2; i <= m; i++) {
			if(flag[i]) continue;
			for(int j = i*2; j <= n; j += i) {
				flag[j] = true;
			}
		}
		
		ArrayList<Integer> psum = new ArrayList<>();
		int k = 1;
		psum.add(0);
		for(int i = 2; i <= n; i++) {
			if(!flag[i]) {
				psum.add(psum.get(k-1) + i);
				k++;
			}
		}
		
		int cnt = 0;
		
		int l = 0, r = 1;
		while(r < k) {
			int sum = psum.get(r) - psum.get(l);
			
			if(sum > n) {
				l++;
			} else if(sum == n) {
				cnt++;
				l++;
				r++;
			} else {
				r++;
			}
		}
		System.out.println(cnt);
	}
}
