import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		
		int arr[] = new int[n+k];
		int check[] = new int[d+1];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < k; i++) {
			arr[n+i] = arr[i];
		}
		
		int l = 0, r = 1;
		int kindCnt = 1;
		check[arr[0]]++;
		int res = 0;
		
		while(r < n+k) {
			if(check[arr[r]] == 0) {
				check[arr[r++]]++;
				kindCnt++;
			} else {
				check[arr[r++]]++;
			}
			
			if(r - l == k) {
				if(check[c] == 0) {
					res = Math.max(kindCnt + 1, res);
				} else {
					res = Math.max(kindCnt, res);
				}
				
				check[arr[l]]--;
				if(check[arr[l]] == 0) {
					kindCnt--;
				}
				l++;
			}
		}
		
		System.out.println(res);
	}
}
