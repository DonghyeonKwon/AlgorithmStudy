import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long min = Long.MAX_VALUE;
	static long[] arr, res = new long[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) arr[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(arr);
		
		if(n == 3) {
			System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
			return;
		}
		
		if(arr[n-1] < 0) {
			System.out.println(arr[n-3] + " " + arr[n-2] + " " + arr[n-1]);
			return;
		}
		
		if(arr[0] > 0) {
			System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
			return;
		}
		
		List<int[]> list = new ArrayList<>();
		
		for(int i = 0; i < n-2; i++) {
			for(int j = i+2; j < n; j++) {
				list.add(new int[] {i, j});
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			System.out.print(arr[i] + " ");
//		}System.out.println();
		
		
		for(int i = 0 ; i < n - 2; i++) {
			int left = i + 1;
			int right = n - 1;
			
			while(left < right) {
				long sum = arr[i] + arr[left] + arr[right];
				if(min > Math.abs(sum)) {
					min = Math.abs(sum);
					res[0] = arr[i];
					res[1] = arr[left];
					res[2] = arr[right];
				}
				if(sum > 0) {
					right--;
				} else if(sum < 0) {
					left++;
				} else break;
			}
		}
		
		System.out.println(res[0] + " " + res[1] + " " + res[2]);
	}
}