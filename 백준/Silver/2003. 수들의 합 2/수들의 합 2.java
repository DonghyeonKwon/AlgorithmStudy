import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//구간합 배열
		int[] psum = new int[n+1];
		for(int i = 1; i <= n; i++) {
			psum[i] = sc.nextInt() + psum[i-1];
		}
		
		//투포인터
		int l = 0, r = 0, res = 0;
		//r포인터가 n보다 작거나 같으면 반복
		while(r <= n) {
			if(l == r) {
				r++;
				continue;
			}
			//l부터 r까지 구간합 구하기
			int sum = psum[r] - psum[l];
			//해당 구간합이 m보다 작으면 r++;
			if(sum < m) {
				r++;
				continue;
			}
			//해당 구간합이 m이면 res++, l++, r++;
			if(sum == m) {
				res++;
				r++;
				l++;
				continue;
			}
			//해당 구간합이 m보다 크면 l++;
			if(sum > m) {
				l++;
				continue;
			}
		}
		//결과 출력
		System.out.println(res);
	}
}