import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] map;
    static Stack<int[]>[] stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        stack = new Stack[c];
        for(int i = 0; i < c; i++) {
            stack[i] = new Stack<>();
        }

        map = new char[r][c];
        for(int i = 0; i < r; i++) {
            String input = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine()) - 1;
            int y = 0, x = 0;
            while(!stack[num].isEmpty()) {
                y = stack[num].peek()[0];
                x = stack[num].peek()[1];
                if(map[y][x] != '.') {
                    stack[num].pop();
                } else {
                    break;
                }
            }

            if(stack[num].isEmpty()) {
                go(0, num, num);
            } else {
                stack[num].pop();
                go(y, x, num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void go(int y, int x, int col) {
        while(y < r) {
            if(map[y][x] == '.') {
                stack[col].push(new int[]{y,x});
            }

            if(map[y][x] == 'X') {
                break;
            }

            if(y + 1 < r && map[y + 1][x] == '.') {
                y++;
                continue;
            } else if(y + 1 < r && map[y+1][x] != '.') {
                if(map[y+1][x] == 'O') {
                    if (x - 1 >= 0 && map[y][x - 1] == '.' && map[y + 1][x - 1] == '.') {
                        x--;
                        y++;
                        continue;
                    } else if (x + 1 < c && map[y][x + 1] == '.' && map[y + 1][x + 1] == '.') {
                        x++;
                        y++;
                        continue;
                    }
                }
            }

            break;
        }

        map[y][x] = 'O';
    }
}
