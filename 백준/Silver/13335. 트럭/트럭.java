import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int w = sc.nextInt();
		int l = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int p = 1;
		int t = 0;
		int sum = 0;
		int cnt = 1;
		int k = 0;
		Queue<Truck> q = new ArrayDeque<>();
		
		sum += arr[0];
		q.offer(new Truck(t + w + 1, arr[0]));
		t = 2;
		while(p < n || !q.isEmpty()) {
			if(q.peek().time == t) {
				Truck truck = q.poll();
				sum -= truck.w;
				cnt--;
				if(p == n && sum == 0) break;
			}
			
			if(cnt < w && p < n && sum + arr[p] <= l) {
				sum += arr[p];
				cnt++;
				q.offer(new Truck(t+w, arr[p++]));
			}
			
			t++;
		}
		
		System.out.println(t);
	}
	
	static class Truck {
		int time;
		int w;
		Truck(int time, int w){
			this.time = time;
			this.w = w;
		}
	}
}
