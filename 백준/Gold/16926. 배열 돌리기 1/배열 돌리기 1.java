import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; n - 2 * i > 0 && m - 2 * i > 0; i++) {
			int len = (n - 2 * i) * (m - 2 * i) - (n - 2 * (i + 1)) * (m - 2 * (i + 1));
			int turn = t % len;
			turnArr(arr, i, n - i, m - i, turn);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void turnArr(int[][] arr, int s, int ey, int ex, int t) {
		while(t --> 0) {
			int sx = s, sy = s;
			
			for(; sx < ex - 1; sx++) {
				arr[sy][sx+1] = swap(arr[sy][sx], arr[sy][sx] = arr[sy][sx+1]);
			}
			for(; sy < ey - 1; sy++) {
				arr[sy+1][sx] = swap(arr[sy][sx], arr[sy][sx] = arr[sy+1][sx]);
			}
			for(; sx > s; sx--) {
				arr[sy][sx-1] = swap(arr[sy][sx], arr[sy][sx] = arr[sy][sx-1]);
			}
			for(; sy > s + 1; sy--) {
				arr[sy-1][sx] = swap(arr[sy][sx], arr[sy][sx] = arr[sy-1][sx]);
			}
		}
	}
	
	static int swap(int a, int b) {
		return a;
	}
}
