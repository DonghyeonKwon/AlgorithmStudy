import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = 0;
		t += 56 * Integer.parseInt(st.nextToken());
		t += 24 * Integer.parseInt(st.nextToken());
		t += 14 * Integer.parseInt(st.nextToken());
		t += 6 * Integer.parseInt(st.nextToken());
		
		System.out.println(t);
	}
}