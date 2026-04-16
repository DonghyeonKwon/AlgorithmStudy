import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	
	static String[] str;
	static int ret = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		str = new String[n];
		
		for(int i = 0; i < n; i++) {
			str[i] = br.readLine();
		}
		
		//소트 후 이진 탐색
		Arrays.sort(str);
		
		for(int i = 0; i < m; i++) {
			String input = br.readLine();
			searchBinary(input);
		}
		
		System.out.println(ret);
	}
	
	static void searchBinary(String input) {
		int l = 0;
		int r = str.length - 1;
		
		while(l <= r) {
			int mid = (l + r) / 2;
//			System.out.println(str[mid]);
//			System.out.println(input);
			if(str[mid].startsWith(input)) {
				ret++;
				break;
			}
			
			if(str[mid].compareTo(input) < 0) {
				l = mid+1;
			} else if (str[mid].compareTo(input) > 0) {
				r = mid - 1;
			}
		}
	}
}