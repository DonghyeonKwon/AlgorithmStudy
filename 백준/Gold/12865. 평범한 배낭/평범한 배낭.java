import java.util.Scanner;

public class Main {
	static int n, k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		int bag[][] = new int[n + 1][k + 1];
		int w[] = new int[n + 1];
		int v[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}

		for (int j = 0; j <= k; j++) { // 각 무게 마다 가치를 계산
			for (int i = 1; i <= n; i++) {
				if (j - w[i] < 0) {
					bag[i][j] = bag[i-1][j];
					continue; // 해당 j에서 w[i]값을 뺀 값이 음수이면 continue
				}
				bag[i][j] = Math.max(bag[i - 1][j - w[i]] + v[i], bag[i - 1][j]);
			}
		}	

		System.out.println(bag[n][k]);
	}
}
