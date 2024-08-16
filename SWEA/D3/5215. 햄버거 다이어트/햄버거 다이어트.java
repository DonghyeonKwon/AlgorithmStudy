import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int n, kcal, ret = -1;
	static int[] point, k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			//입력  및 초기화
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			kcal = Integer.parseInt(st.nextToken());
			point = new int[n];
			k = new int[n];
			ret = -1;
			//첫 번째는 점수, 두 번재는 칼로리
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				point[i] = Integer.parseInt(st.nextToken());
				k[i] = Integer.parseInt(st.nextToken());
			}
			
			selectHamburger(0, 0, 0, 0);
			bw.write("#"+tc+" "+ret+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void selectHamburger(int ecnt, int idx, int point_sum, int kcal_sum) {
		if(idx == n) {
			if(ecnt > 0 && kcal_sum <= kcal && ret < point_sum) {
				ret = point_sum;
			}
			return;
		}
		//햄버거 선택하지 않았을 때
		selectHamburger(ecnt, idx+1, point_sum, kcal_sum);
		//햄버거를 선택했을 때 -> ecnt에 해당 idx 1 넣기, 해당 idx에 대한 점수와 칼로리 더하기
		selectHamburger(ecnt | (1 << idx), idx+1, point_sum + point[idx], kcal_sum + k[idx]);
	}
}
