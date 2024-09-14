import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N+1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		SegmentTree stree = new SegmentTree(N);
		
		stree.init(arr, 1, 1, N);
		
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(cmd == 1) {
				stree.update(1, 1, N, a, b-arr[a]);
				arr[a] = b;
				continue;
			}
			sb.append(stree.sum(1, 1, N, a, (int)b)).append('\n');
		}
		System.out.print(sb);
	}
	
	static class SegmentTree{
		int size;
		long[] tree;
		
		SegmentTree(int n) {
			int h = (int)Math.ceil(Math.log(n)/Math.log(2));
			this.size = pow(2, h+1);
			tree = new long[this.size];
		}
		
		public void init(long[] arr, int node, int start, int end) {
			if(start == end) {
				this.tree[node] = arr[start];
				return;
			}
			init(arr, node*2, start, (start+end)/2);
			init(arr, node*2+1, (start+end)/2 + 1, end);
			this.tree[node] = this.tree[node*2] + this.tree[node*2 + 1];
		}
		
		public void update(int node, int start, int end, int idx, long diff) {
			if(idx < start || end < idx) return;
			
			this.tree[node] += diff;
			
			if(start != end) {
				update(node*2, start, (start + end)/2, idx, diff);
				update(node*2 + 1, (start + end)/2 + 1, end, idx, diff);
			}
		}
		
		public long sum(int node, int start, int end, int left, int right) {
			if(left > end || right < start) {
				return 0;
			}
			
			if(left <= start && end <= right) {
				return tree[node];
			}
			
			return sum(node*2, start, (start+end)/2, left, right) +
					sum(node*2 + 1, (start+end)/2 + 1, end, left, right);
		}
	}
	
	static int pow(int n, int k) {
		if(k == 1) return n;
		if(k % 2 == 1) return pow(n, k/2) * pow(n, k/2) * n;
		return pow(n, k/2) * pow(n, k/2);
	}
}