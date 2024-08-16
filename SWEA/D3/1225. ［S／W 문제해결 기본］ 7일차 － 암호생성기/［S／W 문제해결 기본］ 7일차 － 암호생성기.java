import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//맨 앞에 있는 요소를 계산하여 뒤로 보내는 구조 - 자료구조로 큐가 있다.
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}
			
			int n = 1;
			while(true) {
				int first = queue.poll() - n++;
				if(first <= 0) {
					queue.offer(0);
					break;
				}
				
				if(n == 6) n = 1;
				queue.offer(first);
			}
			
			System.out.print("#"+tc);
			for(int i = 0; i < 8; i++) {
				System.out.print(" " + queue.poll());
			}System.out.println();
		}
	}
}
