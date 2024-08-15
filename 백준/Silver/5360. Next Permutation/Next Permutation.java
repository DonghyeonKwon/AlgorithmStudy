import java.util.Scanner;

public class Main {
	static int n, count, ret = 2_000_001;
	static String[] list, input;
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0) {
			String str = sc.next();
			n = Integer.parseInt(str);
			count = str.length();
			input = str.split("");
			list = new String[count];
			v = new boolean[count];
			ret = 2_000_001;
			go(0);
			
			if(ret == 2_000_001) {
				System.out.println("USELESS");
			}
			else {
				System.out.println(ret);
			}
		}
	}
	
	static void go(int idx) {
		if(count == idx) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < count; i++) {
				sb.append(list[i]);
			}
			
			int num = Integer.parseInt(sb.toString());
			if(n < num && ret > num) {
				ret = num;
			}
			
			return;
		}
		
		for(int i = 0; i < count; i++) {
			if(v[i]) continue;
			v[i] = true;
			list[idx] = input[i];
			go(idx+1);
			v[i] = false;
		}
	}
}
