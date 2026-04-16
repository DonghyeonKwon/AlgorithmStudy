import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		if(input[0] != 'q') {
			System.out.println(-1);
			return;
		}
		
		List<Stack<Character>> list = new ArrayList<>();
		
		int len = input.length;
		for(int i = 0; i < len; i++) {
			char c = input[i];
			boolean check = true;
			
			switch(c) {
			case 'q':
				for(Stack<Character> stk : list) {
					if(stk.peek() == 'k') {
						stk.add(c);
						check = false;
						break;
					}
				}
				if(check) {
					Stack<Character> stk = new Stack<>();
					stk.add(c);
					list.add(stk);
				}
				break;
			case 'u':
				for(Stack<Character> stk : list) {
					if(stk.peek() == 'q') {
						stk.add(c);
						check = false;
						break;
					}
				}
				if(check) {
					System.out.println(-1);
					return;
				}
				break;
			case 'a':
				for(Stack<Character> stk : list) {
					if(stk.peek() == 'u') {
						stk.add(c);
						check = false;
						break;
					}
				}
				if(check) {
					System.out.println(-1);
					return;
				}
				break;
			case 'c':
				for(Stack<Character> stk : list) {
					if(stk.peek() == 'a') {
						stk.add(c);
						check = false;
						break;
					}
				}
				if(check) {
					System.out.println(-1);
					return;
				}
				break;
			case 'k':
				for(Stack<Character> stk : list) {
					if(stk.peek() == 'c') {
						stk.add(c);
						check = false;
						break;
					}
				}
				if(check) {
					System.out.println(-1);
					return;
				}
				break;
			}
		}
        
        for(Stack<Character> stk : list) {
			if(stk.peek() != 'k') {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(list.size());
	}
}