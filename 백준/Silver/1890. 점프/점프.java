import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 백준 1890 점프
 * 메모리 :  KB
 * 시간 :  ms
 *
 */
public class Main {
    static int N;
    static long[][] dp;
    static int[][] table;
    static long ans;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new long[N][N];
        table = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());    
                dp[i][j] = -1;
            }
        }
        // 입력 끝
        ans = dfs(0, 0);
        System.out.println(ans);
    }
    
    static long dfs(int y, int x) {
        // 맨 끝에 도착 하면
        if (y == N-1 && x == N-1) {
            return 1;
        }
        if (y >= 0 && y < N && x >= 0 && x < N ) {
            // 이미 개수를 탐색했던 곳이면
            if (dp[y][x] != - 1)
                return dp[y][x];
            else {
            	dp[y][x] = 0;
            	if (y < N) {
                    dp[y][x] += dfs(y + table[y][x], x);
            	}
            	if (x < N) {
            		dp[y][x] += dfs(y, x + table[y][x]);
            	}
                return dp[y][x];
            	
            }
        }
        else {
        	return 0;
        }
    }
}