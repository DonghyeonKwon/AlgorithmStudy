import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		SegmentTree stree = new SegmentTree(n);
		stree.init(arr, 1, 1, n);
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(stree.getMin(1, 1, n, a, b)).append(' ').append(stree.getMax(1, 1,n, a, b)).append('\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class SegmentTree{
		int size;
		int[] minTree, maxTree;
		
		SegmentTree(int n){
			int h = (int)Math.ceil(Math.log(n)/Math.log(2));
			this.size = pow(2, h+1);
			this.minTree = new int[this.size];
			this.maxTree = new int[this.size];
		}
		
		public void init(int[] arr, int node, int start, int end) {
			if(start == end) {
				this.minTree[node] = arr[end];
				this.maxTree[node] = arr[end];
				return;
			}
			
			init(arr, node*2, start, (start + end)/2);
			init(arr, node*2+1, (start + end)/2+1, end);
			
			minTree[node] = minTree[node*2] < minTree[node * 2+1] ? minTree[node*2] : minTree[node*2 + 1];
			maxTree[node] = maxTree[node*2] > maxTree[node * 2+1] ? maxTree[node*2] : maxTree[node*2 + 1];
		}
		
		public int getMin(int idx, int start, int end, int left, int right) {
			if(end < left || start > right) {
				return Integer.MAX_VALUE;
			}
			
			if(left <= start && end <= right) {
				return minTree[idx];
			}
			
			int mid = (start + end) / 2;
			
			return Math.min(getMin(idx*2, start, mid, left, right), 
					getMin(idx*2+1, mid+1, end, left, right));
		}
		
		public int getMax(int idx, int start, int end, int left, int right) {
			if(end < left || start > right) {
				return Integer.MIN_VALUE;
			}
			
			if(left <= start && end <= right) {
				return maxTree[idx];
			}
			
			int mid = (start + end) / 2;
			
			return Math.max(getMax(idx*2, start, mid, left, right), 
					getMax(idx*2+1, mid+1, end, left, right));
		}
	}
	
	static int pow(int n, int k) {
		if(k == 1) return n;
		if(k % 2 == 1) return pow(n, k/2)*pow(n, k/2)*n;
		return pow(n, k/2)*pow(n, k/2);
	}
}