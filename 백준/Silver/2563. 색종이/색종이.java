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

		int sum = 0;
		boolean[][] v = new boolean[101][101];

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + 10; i++) {
				if (1 <= i && i <= 100) {
					for (int j = y; j < y + 10; j++) {
						if(1 <= j && j <= 100) {
							if(!v[j][i]) {
								v[j][i] = true;
								sum++;
							}
						}
					}
				}
			}
		}
		
		bw.write(sum + "\n");
		bw.close();
		br.close();
	}
}