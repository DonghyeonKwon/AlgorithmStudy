import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int n = input.length();
		for(int i = 0; i < n; i++) {
			char c = input.charAt(i);
			if('A' <= c && c <= 'Z') {
				c -= 'A';
				c += 'a';
				sb.append(c);
			}
			else {
				c -= 'a';
				c += 'A';
				sb.append(c);
			}
		}
		
		System.out.println(sb.toString());
	}
}
