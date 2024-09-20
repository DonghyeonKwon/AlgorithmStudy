import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), count = 0, k = 5;
		
		while(k <= n) {
			count += n / k;
			k *= 5;
		}
		
		System.out.println(count);
	}
}