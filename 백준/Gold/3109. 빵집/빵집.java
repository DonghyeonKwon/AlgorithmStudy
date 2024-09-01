import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int r, c, max = 0;
	static int[] dy = {-1, 0, 1};
	static int[] dx = {1, 1, 1};
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][];
		
		for(int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < r; i++) {
			if(dfs(i, 0)) max++;
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean dfs(int y, int x) {
		if(y < 0 || y >= r) return false;
		if(x == c) return true;
		if(x != 0 && map[y][x] == 'x') return false;
		map[y][x] = 'x';
		return (dfs(y-1, x+1) || dfs(y, x+1) || dfs(y+1, x+1));
	}
}