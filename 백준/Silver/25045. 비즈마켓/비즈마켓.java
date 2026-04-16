import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Long[] aArr = new Long[n];
		for(int i = 0; i < n; i++) {
			aArr[i] = sc.nextLong();
		}
		
		Long[] bArr = new Long[m];
		for(int i = 0; i < m; i++) {
			bArr[i] = sc.nextLong();
		}
		
		Arrays.sort(aArr, (a, b) -> Long.compare(b, a));
		Arrays.sort(bArr);
		
		int small = n < m ? n : m;
		long sum = 0;
		for(int i = 0; i < small; i++) {
			sum += (aArr[i] - bArr[i]) > 0 ? (aArr[i] - bArr[i]) : 0;
		}
		
		System.out.println(sum);
	}
}