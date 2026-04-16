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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int[] v = new int[d+1];
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int l = 0, r = 0, max = 0;
		
		while(l < n) {
			if(v[arr[r%n]] == 0) {
				v[arr[r%n]]++;
				cnt++;
				r++;
			} else {
				v[arr[r%n]]++;
				r++;
			}
			
			if(r - l == k) {
				if(v[c] == 0) {
					if(max < cnt + 1) max = cnt + 1;
				} else {
					if(max < cnt) max = cnt;
				}
				v[arr[l]]--;
				if(v[arr[l]] == 0) cnt--;
				l++;
			}
			
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}