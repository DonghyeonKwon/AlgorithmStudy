import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int count = -1;
	static boolean flag = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int size = calcCnt(n);
		divide(0, 0, size, 0, r, c);
		
		bw.write("" + count);
		bw.close();
		br.close();
	}
	
	static void divide(int starty, int startx, int size, int n, int r, int c) {
		
		if(size == 1) {
			count = n;
			return;
		}
		int a = size/2;
		
		if(check(starty, startx, a, r, c)) divide(starty, startx, a, n, r, c);
		if(check(starty, startx + a, a, r, c)) divide(starty, startx + a, size/2,n + a * a, r, c);
		if(check(starty + a, startx, a, r, c)) divide(starty + a, startx, size/2, n + 2 * a * a, r, c);
		if(check(starty + a, startx + a, a, r, c)) divide(starty + a, startx + a, a, n + 3 * a * a, r, c);
	}
	
	static boolean check(int y, int x, int s, int r, int c) {
		return(y <= r && r < y + s && x <= c && c < x + s);
	}
	
	static int calcCnt(int n) {
		if(n == 1) return 2;
		
		if(n % 2 == 0) return calcCnt(n/2) * calcCnt(n/2);
		else return calcCnt(n/2) * calcCnt(n/2) * 2;
	}
}
