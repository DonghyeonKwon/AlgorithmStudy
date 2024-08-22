import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int broken = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Egg[] eggs = new Egg[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		if(n == 1) {
			bw.write("0\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		
		go(0, eggs, 0, n);
		
		bw.write(""+broken);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void go(int idx, Egg[] eggs, int cnt, int n) {	
		if(cnt == n) {
			broken = cnt;
			return;
		}
		
		if(idx == n) {
			if(cnt > broken) broken = cnt;
			return;
		}
		
		if(eggs[idx].a <= 0 || cnt == n-1) {
			go(idx+1, eggs, cnt, n);
			return;
		}
		
		int pCnt = cnt;
		for(int i = 0; i < n; i++) {
			if(i == idx) continue;
			if(eggs[i].a <= 0) continue;
			
			eggs[idx].a -= eggs[i].b;
			eggs[i].a -= eggs[idx].b;
			
			if(eggs[idx].a <= 0) cnt++;
			if(eggs[i].a <= 0) cnt++;
			
			go(idx+1, eggs, cnt, n);
			
			eggs[idx].a += eggs[i].b;
			eggs[i].a += eggs[idx].b;
			
			cnt = pCnt;
		}
	}
	
	static class Egg{
		int a;	// 내구도
		int b;	// 무게
		
		Egg(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
}