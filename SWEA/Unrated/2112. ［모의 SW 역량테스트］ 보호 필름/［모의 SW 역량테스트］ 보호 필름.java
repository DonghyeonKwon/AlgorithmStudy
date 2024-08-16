import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int d, w, k;
	static int[] column, changedColumn;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			changedColumn = new int[w];
			column = new int[w];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						column[j] |= (1 << i);
					}
				}
			}

			for (int i = 0; i <= k; i++) {
				if (pushMedicine(0, 0, 0, i)) {
					sb.append("#").append(tc).append(" ").append(i).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}

	static boolean pushMedicine(int ecnt, int cnt, int idx, int n) {
		if (cnt == n) {
			// 조합은 완성..
			// A또는 B가 되는 약품 주입 해야할 함수...
			boolean flag = false;
			for (int i = 0; i <= n; i++) {
				flag |= pushAorB(ecnt, 0, 0, 0, i);
			}
			return flag;
		}
		// 약품 넣을 조합 생성
		boolean flag = false;
		for (int i = idx; i < d; i++) {
			flag |= pushMedicine(ecnt | (1 << i), cnt + 1, i + 1, n);
			if (flag)
				break;
		}

		return flag;
	}

	static boolean pushAorB(int field, int ecnt, int cntA, int idx, int n) {
		if(cntA == n) {
			changeArr(field, ecnt);
			
//			System.out.println("" + field + " " + ecnt + " " + cntA + " " + n);
//			for(int i = 0; i < w; i++) {
//				System.out.print( column[i] + " " );
//			}System.out.println();
//			for(int i = 0; i < w; i++) {
//				System.out.print( changedColumn[i] + " " );
//			}System.out.println();
			
			return check();
		}
		
		//A약품 넣을 곳을  조합을 찾는다
		boolean flag = false;
		for(int i = idx; i < d; i++) {
			if((field & (1 << i)) != 0) {
				flag |= pushAorB(field, ecnt | (1 << i), cntA+1, i+1, n);
			}
			if(flag) break;
		}
		return flag;
	}

	static void changeArr(int field, int fieldA) {
		for(int i = 0; i < w; i++) {
			changedColumn[i] = column[i];
		}
		
		for (int i = 0; i < d; i++) {
			if ((field & (1 << i)) != 0) {
				if ((fieldA & (1 << i)) != 0) { // 해당 층에 A 넣기
					for (int j = 0; j < w; j++) {
						changedColumn[j] &= ~(1 << i);
					}
				} else { // 해당 층에 B 넣기
					for (int j = 0; j < w; j++) {
						changedColumn[j] |= (1 << i);
					}
				}
			}
		}
	}

	static boolean check() {
		for (int i = 0; i < w; i++) {
//			System.out.println(i);
			int A = 0, B = 0;
			for (int j = 0; j < d; j++) {
				if ((changedColumn[i] & (1 << j)) > 0) {
					A = 0;
					B++;
				} else {
					B = 0;
					A++;
				}
				if(A >= k || B >= k) break;
			}
			if (A < k && B < k)
				return false;
		}
		return true;
	}
}
