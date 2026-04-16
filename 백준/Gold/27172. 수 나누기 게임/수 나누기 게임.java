import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		// 입력
		int INF = 0;
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			INF = Math.max(INF, arr[i] = Integer.parseInt(st.nextToken()));
		}
		
		int[] point = new int[n+1];
		int[] position = new int[INF+1];
		for(int i = 0; i < n; i++) position[arr[i]] = i + 1;
		
		for(int x : arr) {
			for(int i = x*2; i <= INF; i += x) {
				if(position[i] != 0) {
					point[position[i]]--;
					point[position[x]]++;
				}
			}
		}
		
		for(int i = 1; i <= n; i++) sb.append(point[i]).append(" ");
		System.out.println(sb);
	}
}