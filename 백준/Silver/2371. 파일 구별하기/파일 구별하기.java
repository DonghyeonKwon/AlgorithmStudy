import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, len = -1;
		n = sc.nextInt();
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			List<Integer> tmp = new ArrayList<>();
			int input = 0;
			while(true) {
				input = sc.nextInt();
				if(input == -1) break;
				tmp.add(input);
			}
			if(len < tmp.size()) len = tmp.size();
			list.add(tmp);
		}
		
		for(int i = 1; i <= len; i++) {
			Set<Integer> st = new HashSet<>();
			int zero_cnt = 0;
			for(int j = 0; j < n; j++) {
				List<Integer> tmp = list.get(j);
				if(tmp.size() < i) {
					zero_cnt++;
				} else {
					st.add(tmp.get(i-1));
				}
			}
			if(n == (zero_cnt + st.size())) {
				System.out.println(i);
				break;
			}
		}
	}
}