import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		boolean[] flag = new boolean[10001];
		flag[1] = true;
		
		for(int i = 2; i <= Math.sqrt(10000); i++) {
			for(int j = i * 2; j <= 10000; j += i) {
				flag[j] = true;
			}
		}
		
		int sum = 0, min = 0;
		for(int i = m; i <= n; i++) {
			if(!flag[i] && sum == 0) min = i;
			if(!flag[i]) sum += i;
		}
		
		if(sum == 0) {
			bw.write("-1\n");
		} else {
			bw.write(sum + "\n" + min + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}