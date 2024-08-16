import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int board = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int size = st.countTokens();
			String str = st.nextToken();
			int inputNum = 0;
			if(size == 2) inputNum = Integer.parseInt(st.nextToken()) - 1;
			switch(str) {
			case "add": //x-1 번째에 |(or) 연산으로 추가한다. 이미 있지만 연산하여도 무시가 된다.
				board |= (1 << inputNum);
				break;
			case "remove": // (1 << x-1)비트를 만들고 ~을 통해 비트를 반전시킨 후 &(and)연산으로 제거한다. 이미 있지만 연산하여도 무시가 된다.
				board &= ~(1 << inputNum);
				break;
			case "check": // (1 << x-1) 비트를 만들고 &(and)연산으로 통해  0이 아니면 1을 0이면 1를 출력
				if((board & (1 << inputNum)) != 0) sb.append("1").append("\n");
				else sb.append("0").append("\n");
				break;
			case "toggle": //board에서 x-1 번째에 있는 수를 ^(xor)로 처리하여 있으면 없애고 없으면 생성
				board ^= (1 << inputNum);
				break;
			case "all": //board를 (1 << 20) - 1 로 바꾼다.
				board = (1 << 20) - 1;
				break;
			case "empty": //board를 공집합으로 바꿈
				board = 0;
				break;
			}
		}
		System.out.print(sb);
	}
}