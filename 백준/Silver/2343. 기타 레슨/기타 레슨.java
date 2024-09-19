import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		int sum = 0;
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		int res = 0;
		int left = 1, right = sum;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(check(mid)) {
				right = mid - 1;
				res = mid;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(res);
	}
	
	static boolean check(int mid) {
		int cnt = 0;
		int tmp = mid;
		
		for(int i = 0; i < n; i++) {
			if(mid < arr[i]) return false;
			tmp -= arr[i];
			if(tmp < 0) {
				tmp = mid - arr[i];
				cnt++;
				continue;
			}
			
			if(tmp == 0) {
				tmp = mid;
				cnt++;
				continue;
			}
		}
		
		if(tmp != mid) cnt++;
		
		return m >= cnt;
		
	}
}