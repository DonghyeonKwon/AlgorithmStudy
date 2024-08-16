import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =  sc.nextInt();
		while(t --> 0) {
			//입력
			int n = sc.nextInt();
			Pair[] pairs = new Pair[n];
			for(int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				pairs[i] = new Pair(a, b);
			}
			//배열 a기준으로 오름 차순
			Arrays.sort(pairs);
			int tmp = 0; 	// pairs[0]의 a는 서류 1위 이기에 무조건 cnt가 1이 된다.
							// 그래서 pairs[0]의 b로 합격 여부를 확인한다.
			int cnt = 1;
			for(int i = 1; i < n; i++) {
				//pairs[i]의 a는 pairs[tmp]의 a 보다 큰 수 이다.
				//pairs[tmp].b 보다 작으면 합격한 사람이다.
				if(pairs[tmp].b > pairs[i].b) {
					tmp = i; 
					cnt++;
				}
				//이 로직을 하면 할 수록 tmp는 작아진다.
//				System.out.println(tmp);
			}
			
			System.out.println(cnt);
		}
	}
	
	static class Pair implements Comparable<Pair>{
		int a;
		int b;
		
		Pair(int a, int b){
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Pair p) {
			if(this.a < p.a) return -1;
			return 1;
		}
	}
}
