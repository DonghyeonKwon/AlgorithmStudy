import java.io.*;
import java.util.*;

public class Main {
	static long k, n, res, lo = 1, hi, max = 0, arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Long.parseLong(st.nextToken());
		
		arr = new long[(int)k];
		
		for(int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = max < arr[i] ? arr[i] : max;
		}
		
		long res = 0;
		hi = max;
		
		while(lo <= hi) {
			long mid = (lo + hi) / 2;
						
			if(check(mid)) {
				lo = mid + 1;
				res = mid;
			} else {
				hi = mid - 1;
			}
		}
		
		System.out.println(res);
	}
	
	static boolean check(long mid) {
		long cnt = 0;
		for(int i = 0; i < k; i++) {
			cnt += arr[i]/mid;
		}
				
		return n <= cnt;
	}
}