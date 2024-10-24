import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Stick[] arr = new Stick[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Stick(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr);
		
		int x = arr[0].x;
		int y = arr[0].y;
		int idx = 0;
		long sum = 0;
		
		for(int i = 1; i < n; i++) {
			if(y < arr[i].y) {
				sum += (arr[i].x - x) * y;
				x = arr[i].x;
				y = arr[i].y;
				idx = i;
			}
		}
		
		sum += (arr[n-1].x - x+1) * y;
		
		int hy = y;
		x = arr[n-1].x;
		y = arr[n-1].y;
		
		for(int i = n-2; i >= idx; i--) {
			if(y < arr[i].y) {
				sum -= (x - arr[i].x) * (hy - y);
				x = arr[i].x;
				y = arr[i].y;
			}
		}
		
		bw.write(String.valueOf(sum));
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Stick implements Comparable<Stick>{
		int x, y;
		Stick(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Stick o) {
			return this.x - o.x;
		}
	}
}
