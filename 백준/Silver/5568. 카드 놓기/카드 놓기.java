import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	static int n, k;
	static String[] list;
	static Set<String> s;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		list = new String[n];
		s = new TreeSet<>();
		
		for(int i = 0; i < n; i++) {
			list[i] = br.readLine();
		}
		
		combi(0, 0, "");
		
		bw.write(s.size() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void combi(int ecnt, int cnt, String l) {
		if(cnt == k) {
			s.add(l);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if((ecnt & (1 << i)) > 0) continue;
			combi(ecnt | (1 << i), cnt+1, l + list[i]);
		}
	}
	
}
