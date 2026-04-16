import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = get(n, m);
		
		System.out.println(r);
		System.out.println(n*m/r);
	}
	
	static int get(int n, int m) {
		if(n % m == 0) return m;
		return get(m, n % m);
	}
}