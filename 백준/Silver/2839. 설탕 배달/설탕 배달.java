import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt = 0; //설탕 총 갯수
		int k = n / 5;
		for(int i = k; i >= 0; i--) {
//			System.out.println(cnt);
			int next = n - 5*i;
            if(next == 0){
                cnt = i;
                n = next;
                break;
            }
			if(next > 0 && next % 3 == 0) {
				n -= 5 * i;
				cnt += i;
				cnt += (n / 3);
				n %= 3;
				break;
			}
		}
		
		if(n > 0) {
			if(n % 3 == 0) cnt = n/3;
			else cnt = -1;
		}
		
		System.out.println(cnt);
	}
}
