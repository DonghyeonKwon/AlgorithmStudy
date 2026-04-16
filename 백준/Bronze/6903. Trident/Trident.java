import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int s = sc.nextInt();
		int h = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print("*");
				if(j == 2) {
					System.out.println();
					break;
				}
				for(int k = 0; k < s; k++) {
					System.out.print(" ");
				}
			}
		}
		
		for(int i = 0; i < 2*s+3; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < s+1; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
	}
}