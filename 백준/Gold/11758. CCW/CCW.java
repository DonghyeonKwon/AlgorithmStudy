import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Point[] p = new Point[3];
		for(int i = 0; i < 3; i++) {
			p[i] = new Point(sc.nextInt(), sc.nextInt());
		}
		
		int res = ((p[1].x - p[0].x) * (p[2].y - p[0].y)) - ((p[2].x - p[0].x) * (p[1].y - p[0].y));
		
		System.out.println(res < 0 ? -1 : res > 0 ? 1 : 0 );
	}
	
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
