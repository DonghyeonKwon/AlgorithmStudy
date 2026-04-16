import java.util.Scanner;

//제출용
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//int t = sc.nextInt();
		
		//for(int tc = 1; tc <= t; tc++) {
			//sb.append("#").append(tc).append(" ");
			
			int n = sc.nextInt();
			int x = sc.nextInt();
			int k = sc.nextInt();
			
			boolean[] arr = new boolean[n+1];
			arr[x] = true;
			
			for(int i = 0; i < k; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				boolean tmp = arr[a];
				arr[a] = arr[b];
				arr[b] = tmp;
				
				if(arr[a]) x = a;
				if(arr[b]) x = b;
			}
			//sb.append(x).append("\n");
		//}
		
		System.out.println(x);
		
	}
}
