import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int[] P, S, cards, original;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		P = new int[n];
		S = new int[n];
		cards = new int[n];
		
		for(int i = 0; i < n; i++) {
			P[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			S[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			cards[i] = i;
		}
		original = cards.clone();
		
		int cnt = 0;
		while(!check()) {
			if(cnt != 0 && Arrays.equals(cards, original)) {
				cnt = -1;
				break;
			}
			
			cnt++;
			shuffle();
		}
		
		System.out.println(cnt);
	}
	
	static void shuffle() {
		int[] t = new int[n];
		for(int i = 0; i < n; i++) {
			t[S[i]] = cards[i];
		}
		
		cards = t.clone();
	}
	
	static boolean check() {
		for(int i = 0; i < n; i++) {
			int x = cards[i];
			if(P[x] != i%3) {
				return false;
			}
		}
		return true;
	}
}
