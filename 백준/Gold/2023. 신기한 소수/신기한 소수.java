import java.util.Scanner;

public class Main {
	static int n;
	static StringBuilder sb = new StringBuilder();
	static int[] firstNum = { 2, 3, 5, 7 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		go(0, 0);
		System.out.println(sb);
	}

	static void go(int idx, int num) {
		if (n == idx) {
			sb.append(num).append("\n");
			return;
		}

		if (idx == 0) {
			for(int x : firstNum) {
				go(idx+1, x);
			}
		} else {
			for(int i = 1; i <= 9; i+=2) {
				if(isPrime(num * 10 + i)) {
					go(idx+1, num*10 + i);
				}
			}
		}
	}
	
	static boolean isPrime(int k) {
		for(int i = 2; i <= (int)Math.sqrt(k); i++) {
			if(k % i == 0) return false;
		}
		return true;
	}
}
