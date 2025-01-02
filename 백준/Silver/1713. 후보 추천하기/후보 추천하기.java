import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a = sc.nextInt();
		
		ArrayDeque<Integer> frame = new ArrayDeque<>();
		int[] like = new int[101];
		boolean[] visited = new boolean[101];
		
		int size = 0;
		while(a --> 0) {
			int input = sc.nextInt();
			like[input]++;
			
			if(visited[input]) continue;
			
			if(size < n) {
				if(!visited[input]) {
					visited[input] = true;
					frame.offer(input);
				}
				size++;
				continue;
			}
			
			int delete = 0;
			int cnt = 10000;
			for(int i = 0; i < n; i++) {
				int k = frame.poll();
				
				if(cnt > like[k]) {
					delete = k;
					cnt = like[k];
				}
				
				frame.offer(k);
			}

			for(int i = 0; i < n; i++) {
				int k = frame.poll();
				if(delete == k) continue;
				frame.offer(k);
			}
			
			if(delete == 0) continue;
			frame.offer(input);
			visited[input] = true;
			like[delete] = 0;
			visited[delete] = false;
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.addAll(frame);
		
		Collections.sort(arr);
		
		for(int res : arr) {
			System.out.print(res + " ");
		}
	}
}
