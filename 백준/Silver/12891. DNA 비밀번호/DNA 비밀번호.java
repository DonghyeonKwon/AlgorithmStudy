import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int p, s;
	static String input;
	static int[] acgt = new int[4];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		input = br.readLine();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			acgt[i] = Integer.parseInt(st.nextToken());
		}
		
		int res = 0;
		int l = 0, r = s-1;
		int a = 0, c = 0, g = 0, t = 0;
		for(int j = l; j <= r; j++) {
			if(input.charAt(j) == 'A') a++;
			else if(input.charAt(j) == 'C') c++;
			else if(input.charAt(j) == 'G') g++;
			else if(input.charAt(j) == 'T') t++;
		}
		while(r < p) {
			if(a >= acgt[0] && c >= acgt[1] && g >= acgt[2] && t >= acgt[3]) res++;
//			System.out.println(l + " " + r);
			
			if(input.charAt(l) == 'A') a--;
			else if(input.charAt(l) == 'C') c--;
			else if(input.charAt(l) == 'G') g--;
			else if(input.charAt(l) == 'T') t--;
			
			l++;
			r++;
			if(r >= p) break;
			
			if(input.charAt(r) == 'A') a++;
			else if(input.charAt(r) == 'C') c++;
			else if(input.charAt(r) == 'G') g++;
			else if(input.charAt(r) == 'T') t++;
			
			
		}
		System.out.println(res);
	}
}
