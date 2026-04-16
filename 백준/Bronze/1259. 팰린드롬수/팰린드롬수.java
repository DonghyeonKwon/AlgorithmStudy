import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String str = sc.next();
			if(str.equals("0")) break;
			
			char[] arr = str.toCharArray();
			int s = 0, e = arr.length - 1;
			boolean flag = true;
			while(s <= e) {
				if(arr[s] != arr[e]) {
					flag = false;
					break;
				}
				s++;
				e--;
			}
			if(flag) System.out.println("yes");
			else System.out.println("no");
		}
	}
}