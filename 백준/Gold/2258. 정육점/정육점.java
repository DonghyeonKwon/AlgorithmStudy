import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int cost;
	int weight;

	public Node(int cost, int weight) {
		this.cost = cost;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		if (this.cost == o.cost) return o.weight - this.weight;
		return this.cost - o.cost;
	}
}

public class Main {

	static PriorityQueue<Node> queue = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			queue.offer(new Node(cost, weight));
		}

		int totalC = 0;
		long totalW = 0;

		int min = Integer.MAX_VALUE;

		boolean flag = false;

		int num = -1;
		int same = 0;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int w = node.weight;
			int c = node.cost;

			if (num != c) {
				num = c;
				totalC = c;
			} else {
				totalC += c;
			}

			totalW += w;

			if (totalW >= M) {
				flag = true;
				min = Math.min(min, totalC);
			}
		}

		if (flag) {
			System.out.println(min);
		} else {
			System.out.println(-1);
		}

	}
}