import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Set<Integer> set = new HashSet<Integer>();
		
		if(str.length() == 1) {
			System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
            return;
		}
		
		for(int i = 0; i < str.length()-1; i++) {
//			System.out.println((str.charAt(i) - '0') - (str.charAt(i+1) - '0'));
			set.add((str.charAt(i) - '0') - (str.charAt(i+1) - '0'));
		}
		
		if(set.size() == 1) {
			System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
		} else {
			System.out.println("흥칫뿡!! <(￣ ﹌ ￣)>");
		}
		
		sc.close();
	}
}