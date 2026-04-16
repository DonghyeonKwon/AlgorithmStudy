import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(b == 0) {
				bw.write("Yes\n");
				continue;
			}
			
			if(b == 1) {
				if(a == 0) bw.write("No\n");
				else bw.write("Yes\n");
				continue;
			}

			if (bfs(a, b))
				bw.write("Yes\n");
			else
				bw.write("No\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static boolean bfs(long a, long b) {
		Set<Long> set = new HashSet<>();
		Queue<Long> queue = new LinkedList<>();

		long max = (1L << 33);

		queue.add(a);
		set.add(a);

		while (!queue.isEmpty()) {
			long i = queue.poll();

			if (i == b)
				return true;

			if ((i << 1) % max < max && !set.contains((i << 1) % max)) {
				set.add((i << 1) % max);
				queue.add((i << 1) % max);
			}

			if ((i >> 1) >= 0 && !set.contains((i >> 1))) {
				set.add((i >> 1));
				queue.add((i >> 1));
			}
		}

		return false;
	}
}