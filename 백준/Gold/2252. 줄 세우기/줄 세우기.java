import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int  N, M; // 정점의 개수, 간선의 개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력
		N = sc.nextInt();
		M = sc.nextInt();
		//진입차수관리  배열
		int[] inDegree = new int[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			inDegree[y]++;
		}
		
		ArrayList<Integer> res = new ArrayList<>();
		
		//위상정렬
		//0. 진입차수 관리하기
		//1. 진입차수가 0인 모든 정점을 큐에 삽입한다.
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		//큐 사이즈가 0이면 위상정렬 불가
		if(q.size() == 0) {
			System.out.println("No");
			return;
		}
		
		//2.큐가 빌대까지 임의의 정점을 꺼내 자신과 연결된 정점들의 inDegree의 값을 1씩 감소시킨다.
		//  진입차수가 0이 된 정점은 큐에 삽입한다.
		int cur;
		while(!q.isEmpty()) {
			cur = q.poll(); //큐에서 하나 뽑아내기
			res.add(cur);
			for(int idx : list[cur]) {
				inDegree[idx]--;
				if(inDegree[idx] == 0) { //진입차수가  0이면 큐에 삽입
					q.offer(idx);
				}
			}
		}
		//res의 사이즈가 N이 아니면 위상 정렬 아님
		if(res.size() != N) {
			System.out.println("No");
			return;
		}
		
		
		//출력
		for(Integer n : res) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
