import java.io.*;
import java.util.*;

public class Main {
	
	static int[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		init(n);
		
		int arr[] = new int[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		insert(arr, 1, 1, n);
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(search(1, 1, n, a, b)).append('\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void init(int n) {
		int h = (int)Math.ceil(Math.log(n)/Math.log(2));
		tree = new int[pow(2, h+1)];
	}
	
	static void insert(int[] arr, int node, int start, int end) {
		if(start == end) {
			tree[node] = arr[start];
			return;
		}
		
		int mid = (start+end)/2;
		insert(arr, node * 2, start, mid);
		insert(arr, node * 2 + 1, mid + 1, end);
		
		tree[node] = Math.min(tree[node*2], tree[node*2+1]);
	}
	
	static int search(int node, int start, int end, int left, int right) {
		if(right < start || end < left) return Integer.MAX_VALUE;
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		
		return Math.min(search(node*2, start, mid, left, right), search(node*2+1, mid+1, end, left, right));
	}
	
	static int pow(int n, int k) {
		if(k == 1) return n;
		if(k % 2 == 1) return pow(n, k/2)*pow(n, k/2)*k;
		return pow(n, k/2)*pow(n, k/2);
	}
}