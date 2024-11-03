import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			
			int arr[] = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < n - 5; i++) {
				for(int j = i+1; j < n-4; j++) {
					for(int k = j+1; k < n-3; k++) {
						for(int a = k+1; a < n-2; a++) {
							for(int b = a+1; b < n-1; b++) {
								for(int c = b+1; c < n; c++) {
									sb.append(arr[i]).append(" ").append(arr[j]).append(" ").append(arr[k]).append(" ").append(arr[a]).append(" ").append(arr[b]).append(" ").append(arr[c]).append("\n");
								}
							}
						}
					}
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
