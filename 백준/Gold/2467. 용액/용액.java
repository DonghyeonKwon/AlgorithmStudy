import java.util.Scanner;

public class Main {
	static int n, min = Integer.MAX_VALUE, arr[], res[] = new int[2];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//입력
		n = sc.nextInt();
		arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int l = 0, r = n-1;
		
		while(l < r) {
			int tmp = arr[l] + arr[r];
			int absTmp = tmp < 0 ? -tmp : tmp;
			
			if(min > absTmp) {
				min = absTmp;
				res[0] = arr[l];
				res[1] = arr[r];
			}
			
			if(tmp < 0) l++;
			else r--;
		}
		
		System.out.println(res[0] + " " + res[1]);
	}
}