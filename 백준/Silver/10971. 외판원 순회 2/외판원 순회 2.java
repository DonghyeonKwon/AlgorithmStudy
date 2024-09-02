import java.io.*;
import java.util.*;

public class Main {
	static int n, res = Integer.MAX_VALUE;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//입력
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] arr = new int[n];

		for(int i = 0; i < n; i++) {
			arr[i] = i;
		}
	
		do {
			int sum = 0;
			boolean flag = true;
			for(int i = 0; i < n; i++) {
				if(map[arr[i]][arr[(i+1)%n]] == 0) {
					flag = false;
					break;
				}
				sum += map[arr[i]][arr[(i+1)%n]];
			}
			if(flag && res > sum) res = sum;
		} while(nextPermutation(arr));
		
		bw.write(Integer.toString(res));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean nextPermutation(int[] arr) {
		int N = arr.length;
		
		int i = N - 1;
		while(i > 0 && arr[i-1] > arr[i]) i--;
		
		if(i == 0) return false;
		
		int j = N - 1;
		
		while(arr[i-1] > arr[j]) j--;
		int tmp = arr[i-1];
		arr[i-1]=arr[j];
		arr[j] = tmp;
		
		Arrays.sort(arr, i, N);
		
		return true;
	}
}