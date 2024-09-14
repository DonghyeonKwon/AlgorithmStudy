import java.io.*;
import java.util.*;

public class Main {
	static int k, max = 0, arr[];
	static long n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Long.parseLong(st.nextToken());
		
		arr = new int[k];
		
		for(int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = max < arr[i] ? arr[i] : max;
		}
		
		long res = 0;
		long l = 1, r = (long)max;
		
		while(l <= r) {
			long mid = (r + l) / 2;
						
			if(check(mid)) {
				l = mid + 1;
				res = mid;
			} else {
				r = mid - 1;
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