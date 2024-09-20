import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken()), m = Long.parseLong(st.nextToken());
		long res = n - m;
		
		System.out.println(res < 0 ? -res : res);
	}
}