import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.Month;
import java.util.StringTokenizer;

public class Solution {
	
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int[] value = new int[4];
			int[] month = new int[14];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				value[i] = Integer.parseInt(st.nextToken());
			}
			
			min = value[3];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			} month[12] = month[13] = 1;
			
			go(value, month, 0, 0);
			
			sb.append(min).append("\n");
		}
		bw.write("" + sb);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void go(int[] value, int[] month, int i, int sum) {
		if(min < sum) return;
		
		if(i >= 12) {
			min = Math.min(min, sum);
			return;
		}
		
		if(month[i] == 0) go(value, month, i+1, sum);
		go(value, month, i + 1, sum + value[0] * month[i]);
		go(value, month, i + 1, sum + value[1]);
		if(month[i+1] > 0 && month[i+2] > 0) go(value, month, i + 3, sum + value[2]);
	}
}
