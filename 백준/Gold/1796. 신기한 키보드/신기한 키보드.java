import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static char[] input;
	static int res = 999999999, len;
	static List<Integer>[] list = new ArrayList[26];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		input = sc.next().toCharArray();
		len = input.length;
		
		for(int i = 0; i < 26; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < len; i++) {
			list[input[i] - 'a'].add(i);
		}
		
		go(0, 0, 0);
		
		System.out.println(res);
	}
	
	static void go(int alpha, int idx, int move) {
		if(alpha == 26) {
			res = Math.min(res, move + len);
			return;
		}
		
		if(list[alpha].size() == 0) {
			go(alpha+1, idx, move);
			return;
		}
		
		int first = list[alpha].get(0);
		int last = list[alpha].get(list[alpha].size() - 1);
		
		if(first == last) {
			move += Math.abs(idx - first);
			idx = first;
			go(alpha + 1, idx, move);
		} else {
			int num1 = Math.abs(idx - first);
			int num2 = Math.abs(idx - last);
			
			if(first < idx && idx < last) {
				int temp = move + num1 * 2 + num2;
				go(alpha+1, last, temp);
				
				temp = move + num1 + num2 * 2;
				go(alpha+1, first, temp);
			} else {
				if(num1 < num2) {
					move += num2;
					idx = last;
				} else {
					move += num1;
					idx = first;
				}
				go(alpha+1, idx, move);
			}
		}
	}
}
