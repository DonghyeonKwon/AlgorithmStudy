import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[][] point = new long[2][n+1];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			point[0][i] = Long.parseLong(st.nextToken());
			point[1][i] = Long.parseLong(st.nextToken());
		}
		point[0][n] = point[0][0];
		point[1][n] = point[1][0];
		
		long first = 0L;
		for(int i = 0; i < n; i++) {
			first += (point[0][i] * point[1][i+1]);
		}
		
		long second = 0L;
		for(int i = 0; i < n; i++) {
			second += (point[1][i] * point[0][i+1]);
		}
		
		double ret = Math.abs(first - second) / (double)2;
		System.out.printf("%.1f\n", ret);
	}
}