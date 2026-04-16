import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//---------여기에 코드를 작성하세요.---------------//
		Scanner sc = new Scanner(System.in);
		int kcal = sc.nextInt();
		
		int[] drr = new int[6];
		int[] arr = new int[6];
		
		for(int i = 0; i < 6; i++) {
			drr[i] = sc.nextInt();
			arr[i] = sc.nextInt();
		}
		
		int xw = 0, xh = 0, nw = 0, nh = 0;
		int widx = 0 ,hidx = 0;
		for(int i = 0; i < 6; i++) {
			if(drr[i] == 1 || drr[i] == 2) {
				if(xw < arr[i]) {
					xw = arr[i];
					widx = i;
				}
			} else if(drr[i] == 3 || drr[i] == 4) {
				if(xh < arr[i]) {
					xh = arr[i];
					hidx = i;
				}
			}
		}
		
		if(widx == 0) {
			nw = Math.abs(arr[5] - arr[1]);
		} else if (widx == 5) {
			nw = Math.abs(arr[4] - arr[0]);
		} else {
			nw = Math.abs(arr[widx-1] - arr[widx+1]);
		}
		
		if(hidx == 0) {
			nh = Math.abs(arr[5] - arr[1]);
		} else if (hidx == 5) {
			nh = Math.abs(arr[4] - arr[0]);
		} else {
			nh = Math.abs(arr[hidx -1] - arr[hidx + 1]);
		}
		
		System.out.println(((xw * xh) - (nw * nh)) * kcal );
	}

}