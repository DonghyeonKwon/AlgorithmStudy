import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			bw.write((upper(n, num) - lower(n, num)) + " ");
		}
		bw.write('\n');
		bw.flush();
	}
	
	static int upper(int len, int k) {
		int l = 0;
		int r = len;
		
		while(l < r) {
			int mid = (r + l)/2;
			
			if(arr[mid] <= k) {
				l = mid + 1;
			}
			else if(arr[mid] > k) {
				r = mid;
			}
		}
		
		return l;
	}
	
	static int lower(int len, int k) {
		int l = 0;
		int r = len;
		
		while(l < r) {
			int mid = (r + l)/2;
			
			if(arr[mid] < k) {
				l = mid + 1;
			}
			else if(arr[mid] >= k) {
				r = mid;
			}
		}
		
		return l;
	}
	
	static class Pair{
		int cnt;
		Pair(int cnt){
			this.cnt = cnt;
		}
	}
}
