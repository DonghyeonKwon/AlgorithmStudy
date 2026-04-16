import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[][] dp = new long[31][31];
		
		for(int i = 1; i < 31; i++) {
			for(int j = 1; j <= i; j++) {
				if(j == 1) {
					dp[j][i] = 1;
					continue;
				}
				if(j == i) {
					dp[j][i] = dp[j-1][i-1] + dp[j-1][i];
					continue;
				}
				dp[j][i] = dp[j][i-1] + dp[j-1][i];
			}
		}
/*
 *  1 1 1 1 1 1 1 1 1 1 1
 *  1 2 3 4 5 6 7 
 *  1 3 5 9 14 20 
 *  1 4 9 14 28 48
 *  1 5 14 28 42 90
 *  1 6 20       132
 *  1 7
 *  
 */
//		dp[0] = 0L; // -
//		dp[1] = 1L; // HW 
//		dp[2] = 2L; // HWHW HHWW 
//		//HWHWHW HHWWHW HHWWHW HHWHWW HWHHWW HHWHWW HHHWWW
//		dp[3] = 5L; //HWHWHW HWHHWW HHWHWW HHWWHW HHHWWW 
//		dp[4] = 14L;
//		//HHHHWWWW
//		//HHHWHWWW HHHWWHWW HHHWWWHW 
//		//HHWHHWWW HHWHWHWW HHWHWWHW HHWWHHWW HHWWHWHW 
//		//HWHWHWHW HWHHWHWW HWHWHHWW HWHHHWWW HWHHWWHW 
//		//
		//9,223,372,036,854,775,807
		//3,814,986,502,092,304
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			System.out.println(dp[n][n]);
		}
	}

}
