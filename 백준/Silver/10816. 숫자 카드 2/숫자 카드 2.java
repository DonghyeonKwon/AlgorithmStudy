import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		TreeMap<Integer, Pair> map = new TreeMap<>();
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.get(num) == null) {
				int u = upper(n, num);
				int l = lower(n, num);
				map.put(num, new Pair(u-l));
			}
			sb.append(map.get(num).cnt).append(' ');
		}
		
		System.out.println(sb);
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