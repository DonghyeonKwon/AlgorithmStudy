import java.io.*;
import java.util.*;

public class Main {
	static boolean checked[] = new boolean[100000*20 +1];
	static int n, arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		go(0, 0);
		
		int cnt = 1;
		while(true) {
			if(!checked[cnt]) {
				System.out.println(cnt);
				break;
			}
			cnt++;
		}
	}
	
	static void go(int idx, int sum) {
		if(idx == n) {
			checked[sum] = true;
			return;
		}
		
		go(idx + 1, sum);
		go(idx + 1, sum + arr[idx]);
		
	}
}
