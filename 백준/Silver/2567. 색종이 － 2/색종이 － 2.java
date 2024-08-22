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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		boolean[][] map = new boolean[102][102];
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int k = x; k < x+10 && k <= 100; k++) {
				for(int j = y; j < y + 10 && j <= 100; j++) {
					if(!map[j][k]) {
						map[j][k] = true;
					}
				}
			}
		}
		
		int dy[] = {-1, 0, 1, 0};
		int dx[] = {0, -1, 0, 1};
		
		int res = 0;
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				for(int d = 0; d < 4 && map[i][j]; d++) {
					if(!map[i + dy[d]][j + dx[d]]) res++;
				}
			}
		}
		
		sb.append(res);
		
		bw.write(sb.toString().toCharArray());
		bw.flush();
		bw.close();
		br.close();
	}
}
