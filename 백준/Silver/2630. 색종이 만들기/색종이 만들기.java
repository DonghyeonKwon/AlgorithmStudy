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
		StringTokenizer st;
		
		int[] color = {0, 0}; // 정답 변수 초기화 
		int n = Integer.parseInt(br.readLine()); //크기 입력
		
		//map 입력
		int[][] map = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go(map, 0, 0, n, color);
		
		bw.write(color[0] + "\n" + color[1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static void go(int[][] map, int starty, int startx, int size, int[] color) {
		int sum = 0; // 1의 개수 구하기
		for (int i = starty; i < starty + size; i++) {
			for (int j = startx; j < startx + size; j++) {
				sum += map[i][j];
			}
		}

		if (sum == 0) { // sum 0 이면 해당 영역은 흰색이다
			color[0]++;
		} else if (sum == size * size) { // size^2 과 sum이 같으면 컬러종이++
			color[1]++;
		} else {
			go(map, starty, startx, size / 2, color);
			go(map, starty + (size / 2), startx, size / 2, color);
			go(map, starty, startx + (size / 2), size / 2, color);
			go(map, starty + (size / 2), startx + (size / 2), size / 2, color);
		}

	}
}
