import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0, cnt = 1;
		while((a = sc.nextInt()) != 0) {
			sc.nextLine();
			Map<String, Boolean> mp = new HashMap<>();
			for(int i = 0; i < a; i++) {
				String str = sc.nextLine();
				mp.put(str, true);
			}
			
			System.out.println("Week " + cnt++ + " " + mp.size());
		}
	}
}