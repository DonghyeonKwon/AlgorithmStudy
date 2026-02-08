import java.io.*;
import java.util.*;

public class Main {
    static int n, k, step = 0, broken = 0;
    static Belt[] belts;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belts = new Belt[2 * n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 2 * n; i++) {
            belts[i] = new Belt(Integer.parseInt(st.nextToken()));
        }

        simulation();
    }

    public static void simulation() {

        while(true) {
            step++;
            //1
            turn();
            //2
            moveRobot();
            //3
            if(belts[1].hp >= 1) {
                belts[1].robot = true;
                belts[1].hp -= 1;
                if(belts[1].hp == 0) {
                    broken++;
                }
            }

            //4
            if(broken >= k) break;
        }

        System.out.print(step);
    }

    public static void turn() {
        for(int i = 2 * n; i > 1; i--) {
            Belt temp = belts[i];
            belts[i] = belts[i-1];
            belts[i-1] = temp;
        }

        belts[n].robot = false;
    }

    static void moveRobot() {
        for(int i = n - 1; i >= 1; i--) {
            if(!belts[i].robot) continue;
            if(belts[i+1].hp >= 1 && !belts[i+1].robot) {
                belts[i].robot = false;
                belts[i+1].hp -= 1;
                if(belts[i+1].hp == 0) {
                    broken += 1;
                }
                if(i + 1 == n) continue;
                belts[i+1].robot = true;
            }
        }
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
