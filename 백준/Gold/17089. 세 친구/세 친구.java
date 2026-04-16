import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Set<Integer> list[] = new HashSet[n+1];
		for(int i = 1; i <= n; i++) {
			list[i] = new HashSet<>();
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[r].add(c);
			list[c].add(r);
		}
		
		int res = Integer.MAX_VALUE;
		for(int i = 1; i <= n; i++) {
			for(int j : list[i]) {
				for(int k : list[j]) {
					if(list[i].contains(k)) {
//						Set<Integer> set = new HashSet<>();
//						set.addAll(list[i]);
//						set.addAll(list[j]);
//						set.addAll(list[k]);
						
						int cnt = list[i].size() - 2;
						cnt += list[j].size() - 2;
						cnt += list[k].size() - 2;
						
						res = res > cnt ? cnt : res;
					}
				}
			}
		}
		
		if(res == Integer.MAX_VALUE) res = -1;
		System.out.println(res);
	}
}
