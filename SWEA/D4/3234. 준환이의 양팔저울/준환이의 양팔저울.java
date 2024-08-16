import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, res = 0;
	static int[] arr, selected;

	public static void main(String[] args) throws IOException {
		// 입출력기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// 입력
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			res = 0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			selected = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			makePermetation(0, 0);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	static int fact(int k) {
		if (k == 1) return 1;
		return k * fact(k - 1);
	}

	static void makePermetation(int ecnt, int cnt) {
		if (cnt == n) {
			getResultByCombination(0, 0, 0);
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((ecnt & (1 << i)) != 0) continue;
			selected[cnt] = arr[i];
			makePermetation(ecnt | (1 << i), cnt + 1);
		}
	}

	static void getResultByCombination(int cnt, int rw, int lw) {
		if(lw < rw) return;
		if(cnt == n) {
			res++;
			return;
		}
		getResultByCombination(cnt + 1, rw + selected[cnt], lw);
		getResultByCombination(cnt+1, rw, lw + selected[cnt]);
	}
}
