import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a, b, c, d, u, count = 0L;
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		d = Long.parseLong(st.nextToken());
		u = Long.parseLong(st.nextToken());
		
		if(a <= u) count = (u - a) / b + 1;
		
		if(d == 1L && c <= u) {
			if(a != c && (c <= a || (c-a) % b != 0L)) count++;
		} else {
			while(c <= u) {
				if(c < a || (c-a) % b != 0L) count++;
				c *= d;
			}
		}
		
		System.out.println(count);
	}
}