import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> list, tree;
	static int[] parentArr, size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		parentArr = new int[n+1];
		size = new int[n+1];
		list = new ArrayList<>();
		tree = new ArrayList<>();
		
		for(int i = 0; i <= n+1; i++) {
			list.add(new ArrayList<Integer>());
			tree.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		makeTree(r, -1);
		countSubtreeNodes(r);
		
//		for(List<Integer> li : tree) {
//			for(int i : li) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < q; i++) {
			sb.append(size[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void makeTree(int currentNode, int parent) {
		for(int node : list.get(currentNode)) {
			if(node != parent) {
				tree.get(currentNode).add(node);
				parentArr[node] = currentNode;
				makeTree(node, currentNode);
			}
		}
	}
	
	static void countSubtreeNodes(int currentNode) {
//		System.out.println("Node : " );
		size[currentNode] = 1;
		for(int node : tree.get(currentNode)) {
			countSubtreeNodes(node);
			size[currentNode] += size[node];
		}
	}
}