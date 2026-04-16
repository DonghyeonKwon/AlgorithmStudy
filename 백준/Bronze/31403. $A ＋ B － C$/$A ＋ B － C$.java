import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(a + b - c);
		int count = 1;
		int tmp = b;
		while(tmp > 0) {
			tmp /= 10;
			count *= 10;
		}
		System.out.println(a * count + b - c);
	}
}