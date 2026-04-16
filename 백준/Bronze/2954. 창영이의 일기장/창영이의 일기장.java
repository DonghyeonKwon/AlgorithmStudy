import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));                  
		StringBuilder sb = new StringBuilder();
		char[] input = br.readLine().toCharArray();
		
		int n = input.length;
		for(int i = 0; i < n; i++) {
			sb.append(input[i]);
			if(check(input[i])) i += 2;
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean check(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}
