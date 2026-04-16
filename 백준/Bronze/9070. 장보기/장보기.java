import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			double minRate = 100000;
			int bestPrice = 100000;
			Product[] products = new Product[n];
			for(int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				double rate = (double)b/a;
				if(rate < minRate) {
					minRate = rate;
					bestPrice = b;
				} else if(rate == minRate && b < bestPrice) {
					bestPrice = b;
				}
			}
			
			sb.append(bestPrice).append('\n');
		}
		System.out.println(sb);
	}
	
	static class Product {
		int a, b;
		Product(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
