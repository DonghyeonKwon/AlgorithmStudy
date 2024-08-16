import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static Set<Integer> set;
	static int n, m, res = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; tc++) {
			set = new HashSet<>();
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				//조합에 들어가면 안 되는 조합은 Set에 저장 (중복 제거 목표)
				int a = 0;
				a |= (1 << (Integer.parseInt(st.nextToken()) - 1));
				a |= (1 << (Integer.parseInt(st.nextToken()) - 1));
				set.add(a);
			}
			res = 0;
			subSet(0, 0);
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	static void subSet(int ecnt, int idx) {
		if(idx == n) {
			for(int caseNum : set) {
//				System.out.println("caseNum : " + caseNum);
//				System.out.println("(ecnt & caseNum) : " + (ecnt & caseNum));
				if((ecnt & caseNum) == caseNum) return;
			}
			res++;
			return;
		}
		
		subSet(ecnt | (1 << idx), idx+1);
		subSet(ecnt, idx+1);
	}
}
