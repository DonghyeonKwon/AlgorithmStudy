import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger b1 = new BigInteger(st.nextToken());
		BigInteger b2 = new BigInteger(st.nextToken());
		bw.write(b1.add(b2).toString());
		bw.flush();
		br.close();
		bw.close();
	}
}