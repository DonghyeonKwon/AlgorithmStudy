
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static class Meeting implements Comparable<Meeting>{
		int start, end;
		
		public Meeting(int start, int end) {
			this.end = end;
			this.start = start;
		}

		@Override
		public int compareTo(Meeting o) { //종료 시간이 빠른 순, 같다면 시작 시간이 빠른 순
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Meeting[] meetings = new Meeting[n];
		for(int i = 0; i < n; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(meetings);
		
		List<Meeting> list = new ArrayList<>();
		list.add(meetings[0]);
		
		for(int i = 1; i < n; i++) {
			if(list.get(list.size() - 1).end <= meetings[i].start) {
				list.add(meetings[i]);
			}
		}
		
		System.out.println(list.size());
	}
}
