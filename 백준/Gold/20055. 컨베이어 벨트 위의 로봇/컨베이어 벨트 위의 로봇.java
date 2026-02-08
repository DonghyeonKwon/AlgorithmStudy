import java.io.*;
import java.util.*;

public class Main {
    static int n, k, step = 1, broken = 0;
    static int[] belts;
    static boolean[] robotCheck;
    static Queue<Integer> robots;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belts = new int[2 * n + 1];
        robotCheck = new boolean[2 * n + 1];
        robots = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 2 * n; i++) {
            belts[i] = Integer.parseInt(st.nextToken());
        }

        simulation();
    }

    public static void simulation() {

        while(true) {
            //1
            turn();

            //2
            moveRobot();

            //3
            if(belts[1] != 0) {
                robots.add(1);
                belts[1] -= 1;
                if(belts[1] == 0) {
                    broken++;
                }
            }

            //4
            if(broken >= k) break;
            step++;
        }

        System.out.print(step);
    }

    public static void turn() {
        int belt = belts[2 * n];

        for(int i = 2 * n; i > 1; i--) {
            belts[i] = belts[i-1];
        }
        belts[1] =  belt;

        Queue<Integer> temp = new ArrayDeque<>();

        while(!robots.isEmpty()) {
            int robot = robots.poll();
            robotCheck[robot] = false;

            int nextIdx = robot + 1;

            if(nextIdx == n) continue;
            if(nextIdx > 2 * n) nextIdx = 1;

            robotCheck[nextIdx] = true;
            temp.add(nextIdx);
        }

        robots = temp;
    }

    static void moveRobot() {
        Queue<Integer> temp = new ArrayDeque<>();

        while(!robots.isEmpty()) {
            int robot = robots.poll();

            int nextIdx = robot + 1;
            if(nextIdx > 2 * n) {
                nextIdx = 1;
            }

            if(!robotCheck[nextIdx] && belts[nextIdx] >= 1) {
                belts[nextIdx] -= 1;
                if(belts[nextIdx] == 0) broken++;
                robotCheck[robot] = false;

                if(nextIdx == n) continue;
                robotCheck[nextIdx] = true;
                temp.add(nextIdx);
            } else {
                temp.add(robot);
            }
        }

        robots = temp;
    }

    static class Belt {
        int hp;
        boolean robot;

        Belt(int hp) {
            this.hp = hp;
            this.robot = false;
        }
    }
}
