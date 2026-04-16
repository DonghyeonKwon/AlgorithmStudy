import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] person = new int[6];
		for(int i = 0; i < 6; i++) {
			person[i] = sc.nextInt();
		}
		int t = sc.nextInt();
		int p = sc.nextInt();
		
		int cnt = 0;
		for(int i = 0; i < 6; i++) {
			cnt += person[i] / t;
			if(person[i] % t > 0) cnt++;
		}
		
		System.out.println(cnt);
		System.out.println((n/p) + " " + (n%p));
	}
}
