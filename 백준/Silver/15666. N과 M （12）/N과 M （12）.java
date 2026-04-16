import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static Map<Integer, Boolean> map = new HashMap<>();
	static List<Integer> list = new ArrayList<>();
	static int[] res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(map.get(a) == null) {
				map.put(a, true);
				list.add(a);
				continue;
			}
			if(map.get(a)) continue;
			list.add(Integer.parseInt(st.nextToken()));
			map.put(a, true);
		}
		res = new int[m];
		
		Collections.sort(list);
		
		go(0, 0);
		
	}
	
	static void go(int start, int cnt) {
		if(cnt == m) {
			for(int i : res) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < list.size(); i++) {
			res[cnt] = i;
			go(i, cnt + 1);
		}
	}
}