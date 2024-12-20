import java.util.Scanner;

public class Main {
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			char[] input = sc.next().toCharArray();
			if(input[0] == 'e') break;
			int xCnt = 0;
			int oCnt = 0;
			
			map = new char[3][3];
			for(int i = 0; i < 9; i++) {
				map[i/3][i%3] = input[i];
				if(input[i] == 'X') xCnt++;
				if(input[i] == 'O') oCnt++;
			}
			
			if(xCnt == oCnt + 1) {
				if(xCnt + oCnt == 9 && !bingo('O')) {
					sb.append("valid\n");
				} else if(!bingo('O') && bingo('X')) {
					sb.append("valid\n");
				} else {
					sb.append("invalid\n");
				}
			} else if(xCnt == oCnt) {
				if(!bingo('X') && bingo('O')) {
					sb.append("valid\n");
				} else {
					sb.append("invalid\n");
				}
			} else {
				sb.append("invalid\n");
			}
		}
        System.out.println(sb);
    }
	
	static boolean bingo(char c) {
		for(int i = 0 ; i < 3; i++) {
			if(map[i][0] == c && map[i][1] == c && map[i][2] == c) {
				return true;
			}
		}
		
		for(int i = 0 ; i < 3; i++) {
			if(map[0][i] == c && map[1][i] == c && map[2][i] == c) {
				return true;
			}
		}
		
		if(map[0][0] == c && map[1][1] == c && map[2][2] == c) return true;
		
		if(map[0][2] == c && map[1][1] == c && map[2][0] == c) return true;
		
		return false;
	}
}
