import java.io.*;
import java.util.*;

public class Main {
	static int a, b, n, m;
	static int[][] map = new int[101][101];
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		Robot[] robots = new Robot[n + 1];
		Command[] cmds = new Command[m];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[y][x] = i;
			int d = direction(st.nextToken());
			robots[i] = new Robot(x, y, d);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int rNum = Integer.parseInt(st.nextToken());
			char cmd = st.nextToken().charAt(0);
			int cycle = Integer.parseInt(st.nextToken());
			cmds[i] = new Command(rNum, cmd, cycle);
		}

		int i = -1;
		boolean flag = true;
		while (++i < m && flag) {
			Robot r = robots[cmds[i].rNum];
			
			if (cmds[i].cmd == 'F') {
				flag &= go(r, cmds[i]);
				continue;
			}

			int k = cmds[i].cycle % 4;
			if (k == 1) {
				if(cmds[i].cmd == 'L') turnL(r);
				else turnR(r);
			} else if (k == 2) {
				r.d = (r.d + 2) % 4;
			} else if (k == 3) {
				if(cmds[i].cmd == 'L') turnR(r);
				else turnL(r);
			}

		}

		if (flag)
			System.out.println("OK");
	}
	
	static boolean go(Robot r, Command cmd) {
		int y = r.y, x = r.x, d = r.d;
		
		for(int i = 0; i < cmd.cycle; i++) {
			y += dy[d];
			x += dx[d];
			
			if(y < 1 || y > b || x < 1 || x > a) {
				System.out.println("Robot "+ cmd.rNum +" crashes into the wall");
				return false;
			}
			
			if(map[y][x] > 0) {
				System.out.println("Robot " + cmd.rNum + " crashes into robot " + map[y][x]);
				return false;
			}
		}
		
		map[y][x] = cmd.rNum;
		map[r.y][r.x] = 0;
		r.y = y;
		r.x = x;
		
		return true;
	}

	static int direction(String d) {
		if (d.equals("N"))
			return 0;
		if (d.equals("W"))
			return 1;
		if (d.equals("S"))
			return 2;
		return 3;
	}

	static void turnL(Robot r) {
		r.d = (r.d + 1) % 4;
	}

	static void turnR(Robot r) {
		r.d -= 1;
		if(r.d < 0) r.d = 3;
	}

	static class Robot {
		int y, x, d;

		Robot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static class Command {
		int rNum;
		char cmd;
		int cycle;

		Command(int rNum, char cmd, int cycle) {
			this.cmd = cmd;
			this.cycle = cycle;
			this.rNum = rNum;
		}
	}
}