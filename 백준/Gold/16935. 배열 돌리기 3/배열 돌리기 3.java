import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			switch(Integer.parseInt(st.nextToken())) {
				case 1:
					updown();
					break;
				case 2:
					leftright();
					break;
				case 3:
					turnRight();
					break;
				case 4:
					turnLeft();
					break;
				case 5:
					turnRightGroup();
					break;
				case 6:
					turnLeftGroup();
					break;
			}
		}
		
		int h = arr.length;
		int w = arr[0].length;
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				bw.write(arr[i][j] +" ");
			}
			bw.write("\n");;
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int swap(int A, int B) {
		return A;
	}
	
	static void updown() {
		int h = arr.length;
		int w = arr[0].length;
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h/2; j++) {
				arr[h -j - 1][i] = swap(arr[j][i], arr[j][i] = arr[h -j - 1][i]);
			}
		}
	}
	
	static void leftright() {
		int h = arr.length;
		int w = arr[0].length;
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w/2; j++) {
				arr[i][w - j - 1] = swap(arr[i][j], arr[i][j] = arr[i][w - j - 1]);
			}
		}
	}
	
	//90도 시계반향 회전
	static void turnRight() {
		int h = arr.length;
		int w = arr[0].length;
		
		int[][] tmp = new int[w][h];
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				tmp[i][j] = arr[h - j - 1][i];
			}
		}
		
		arr = tmp;
	}
	
	//90도 반시계반향 회전
	static void turnLeft() {
		int h = arr.length;
		int w = arr[0].length;
		
		int[][] tmp = new int[w][h];
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				tmp[i][j] = arr[j][w - i - 1];
			}
		}
		
		arr = tmp;
	}
	
	static void turnRightGroup() {
		int h = arr.length;
		int w = arr[0].length;
		
		for(int i = 0; i < h/2; i++) {
			for(int j = 0; j < w/2; j++) {
				arr[h/2 + i][j] = swap(arr[i][j], arr[i][j] = arr[h/2 + i][j]);
			}
		}
		
		for(int i = h/2; i < h; i++) {
			for(int j = 0; j < w/2; j++) {
				arr[i][w/2 + j] = swap(arr[i][j], arr[i][j] = arr[i][w/2 + j]);
			}
		}
		
		for(int i = 0; i < h/2; i++) {
			for(int j = w/2; j < w; j++) {
				arr[h/2 + i][j] = swap(arr[i][j], arr[i][j] = arr[h/2 + i][j]);
			}
		}
	}
	
	static void turnLeftGroup() {
		int h = arr.length;
		int w = arr[0].length;
		
		for(int i = 0; i < h/2; i++) {
			for(int j = 0; j < w/2; j++) {
				arr[i][w/2 + j] = swap(arr[i][j], arr[i][j] = arr[i][w/2 + j]);
			}
		}
		
		for(int i = 0; i < h/2; i++) {
			for(int j = w/2; j < w; j++) {
				arr[h/2 + i][j] = swap(arr[i][j], arr[i][j] = arr[h/2 + i][j]);
			}
		}
		
		for(int i = h/2; i < h; i++) {
			for(int j = 0; j < w/2; j++) {
				arr[i][w/2 + j] = swap(arr[i][j], arr[i][j] = arr[i][w/2 + j]);
			}
		}
	}
}
