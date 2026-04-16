import java.util.Scanner;

public class Main {
	static final double[] MOL = {1.008, 12.010, 14.010, 16.000};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			char[] str = sc.next().toCharArray();
			int[] cnt = new int[4];
			for(int j = 0; j < str.length; j++) {
				String num = "";
				if(str[j] == 'C') {
					if(j+1 < str.length && '0' <= str[j+1] && str[j+1] <= '9') {
						num += str[j+1];
						j++;
						if(j+1 < str.length && '0' <= str[j+1] && str[j+1] <= '9') {
							num += str[j+1];
							j++;
						}
					}
					if(num.length() == 0) {
						cnt[1]++;
					} else {
						cnt[1] += Integer.parseInt(num);
					}
				} else if(str[j] == 'H') {
					if(j+1 < str.length && '0' <= str[j+1] && str[j+1] <= '9') {
						num += str[j+1];
						j++;
						if(j+1 < str.length && '0' <= str[j+1] && str[j+1] <= '9') {
							num += str[j+1];
							j++;
						}
					}
					if(num.length() == 0) {
						cnt[0]++;
					} else {
						cnt[0] += Integer.parseInt(num);
					}
				} else if(str[j] == 'N') {
					if(j+1 < str.length && '0' <= str[j+1] && str[j+1] <= '9') {
						num += str[j+1];
						j++;
						if(j+1 < str.length && '0' <= str[j+1] && str[j+1] <= '9') {
							num += str[j+1];
							j++;
						}
					}
					if(num.length() == 0) {
						cnt[2]++;
					} else {
						cnt[2] += Integer.parseInt(num);
					}
				} else if(str[j] == 'O') {
					if(j+1 < str.length && '0' <= str[j+1] && str[j+1] <= '9') {
						num += str[j+1];
						j++;
						if(j+1 < str.length && '0' <= str[j+1] && str[j+1] <= '9') {
							num += str[j+1];
							j++;
						}
					}
					if(num.length() == 0) {
						cnt[3]++;
					} else {
						cnt[3] += Integer.parseInt(num);
					}
				}
			}
			
			double ret = 0.0;
			for(int k = 0; k < 4; k++) {
				ret += MOL[k] * cnt[k];
			}
			System.out.printf("%.3f\n", ret);
		}
	}
}
