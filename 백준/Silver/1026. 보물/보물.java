import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 배열 입력
		int[] A, B;
		A = new int[n];
		B = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) B[i] = Integer.parseInt(st.nextToken());
		//정렬
		Arrays.sort(A);
		Arrays.sort(B);
		//정답 구하기
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += (A[i] * B[n-1-i]);
		}
		System.out.println(sum);
	}
}
