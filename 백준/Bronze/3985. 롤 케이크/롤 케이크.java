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
		
		int l = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		boolean[] cake = new boolean[l];

		
		int max = 0, maxIdx = 0, realmax = 0, realIdx = 0;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			
			int len = e - s + 1;
			if(max < len) {
				max = len;
				maxIdx = i+1;
			}
			
			len = 0;
			for(int x = s; x <= e; x++) {
				if(cake[x]) continue;
				cake[x] = true;
				len++;
			}
			
			if(realmax < len) {
				realmax = len;
				realIdx = i + 1;
			}
		}
		bw.write(maxIdx + "\n" + realIdx);
		bw.close();
		br.close();
	}
	
	static class Person{
		int x;
		int y;
		
		Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}