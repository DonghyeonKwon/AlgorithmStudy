import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		int[] resArr = new int[2];
		int l = 0, r = n - 1;
		
//		if(arr[l] >= 0) {
//			System.out.println(arr[l] + " " + arr[l+1]);
//			return;
//		}
//		
//		if(arr[r] <= 0) {
//			System.out.println(arr[r-1] + " " + arr[r]);
//			return;
//		}
//		
//		for(int i = 0; i < n; i++) {
//			
//		}
		while(l < r) {
			int mix = arr[l] + arr[r];
			
//			if(mix == 0) {
//				System.out.println(arr[l] + " " + arr[r]);
//				break;
//			}
			
			if(min > Math.abs(mix)) {
				min = Math.abs(mix);
				resArr[0] = arr[l];
				resArr[1] = arr[r];
			}
			
			if(mix < 0) l++;
			else r--;
		}
		
		System.out.println(resArr[0] + " " + resArr[1]);
	}
}
