import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split("");
		String[] b = br.readLine().split("");
		
		
		//로마수 -> 정수
		int ret_a = calc(a);
		int ret_b = calc(b);
		int ret = ret_a + ret_b;
		System.out.println(ret);
		
		//정수 -> 로마
		String ret_str = calcRoma((ret + "").split(""));
//		String ret_str = calcRoma(br.readLine().split(""));
		
		System.out.println(ret_str);
	}
	
	static void init() {
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
	}
	
	static int calc(String[] a) {
		int res = 0;
		
		int i = 0;
		for(; i < a.length -1 ; i++) {
			int cur = map.get(a[i]);
			int next = map.get(a[i+1]);
			if(cur < next) {
				res += next - cur;
				i++;
			} else {
				res += cur;
			}
		}
		if(i == a.length - 1) res += map.get(a[i]);
		
		return res;
	}
	
	static String calcRoma(String[] num) {
		StringBuilder sb = new StringBuilder();
		
		int len = num.length;
		int n = (int)Math.pow(10, len-1);
		
		for(int i = 0; i < len; i++) {
			int a = Integer.parseInt(num[i]);
			//System.out.println(a);
			if(n == 1000) {
				for(int j = 0; j < a; j++) {
					sb.append("M");
				}
			} else if(n == 100) {
				if(a == 9) {
					sb.append("CM");
				} else if(a == 4) {
					sb.append("CD");
				} else {
					if(a >= 5) {
						sb.append("D");
						a -= 5;
					}
					for(int j = 0; j < a; j++) {
						sb.append("C");
					}
				}
			} else if(n == 10) {
				if(a == 9) {
					sb.append("XC");
				} else if(a == 4) {
					sb.append("XL");
				} else {
					if(a >= 5) {
						sb.append("L");
						a -= 5;
					}
					for(int j = 0; j < a; j++) {
						sb.append("X");
					}
				}
			} else if(n == 1) {
				if(a == 9) {
					sb.append("IX");
				} else if(a == 4) {
					sb.append("IV");
				} else {
					if(a >= 5) {
						sb.append("V");
						a -= 5;
					}
					for(int j = 0; j < a; j++) {
						sb.append("I");
					}
				}
			}
			n /= 10;
		}
		
		return  sb.toString();
	}
}