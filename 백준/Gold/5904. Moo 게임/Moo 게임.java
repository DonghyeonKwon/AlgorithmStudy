import java.io.*;

public class Main {
	static int[] arr = new int[30];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int k = 3, sum = 0, cnt = -1;
		while(sum < n) {
			sum = sum * 2 + k;
			k++;
			cnt++;
			arr[cnt] = sum;
		}
		
		char res = divide(cnt, n);
		
		System.out.println(res);
	}
	
	static char divide(int x, int now) {
		if(x == 0) {
			if(now == 1) return 'm';
			return 'o';
		}
		
		if(now > arr[x-1] + x + 3) {
			return divide(x-1, now - (arr[x-1] + x + 3));
		} else if (now <= arr[x-1]) {
			return divide(x-1, now);
		} else {
			return divide(x-1, now - arr[x-1]);
		}
		
	}
}