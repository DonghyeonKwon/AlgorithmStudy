import java.util.*;

public class Main {
	static int n, m, l, arr[], max = 0, res = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//입력
		n = sc.nextInt();
		m = sc.nextInt();
		l = sc.nextInt();
		arr = new int[n + 2];
		
		//arr[0]과 arr[n+1]에 0과 l를 저장한다.
		arr[0] = 0;
		for(int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		arr[n+1] = l;
		//이분 탐색 전 정렬
		Arrays.sort(arr);
		
		//lo, hi 설정
		int lo = 1, hi = l;
		while(lo <= hi) {
			//중간값 -> 휴게소간의 거리
			int mid = (lo + hi) / 2;
			
			//중간값 체크
			if(check(mid)) {
				hi = mid - 1;
				res = mid;
			} else {
				lo = mid + 1;
			}
		}
		
		System.out.println(res);
	}
	
	static boolean check(int mid) {
		int cnt = 0;
		
		for(int i = 0; i <= n; i++) {
			int diff = arr[i+1] - arr[i];
			if(diff < mid) continue;
			
			//나머지가 없으면 나눈 몫은 그대로 더해주면 이미 있는 휴게소에 새로 새운 것이 된다.
			//그래서 나눈 몫에 1을 빼야한다.
			if(diff % mid == 0) {
				cnt += diff/mid - 1;
			} else {
				cnt += diff/mid;
			}
		}
		
		if(cnt <= m) {
			return true;
		}
		return false;
	}
}