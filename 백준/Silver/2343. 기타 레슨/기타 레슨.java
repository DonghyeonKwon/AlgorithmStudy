import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
		
		//sum 은 블루레이의 최댓값
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		
		int res = 0;
		int left = 1, right = sum;
		//이분탐색
		while(left <= right) {
			int mid = (left + right) / 2;
			
			//mid값(블루레이 크기)로 설정하고 몇개의 강의가 나오는 본다.
			//check()가 true면 mid값으로 블루레이 크기를 설정했을 때,
			//cnt가 m미만이면 블루레이 크기를 줄이기 위해, cnt == m이면 최솟값을 찾기 위해 right값을 줄인다.
			//반대로 false면 mid값이 작아 블루레이가 생성 되지 않거나 많이 생성된 경우이다.
			//left값을 늘려 블루레이 크기를 키운다.
			if(check(mid)) {
				right = mid - 1;
				res = mid;
			} else {
				left = mid + 1;
			}
		}
		//결과 출력 
		bw.write(Integer.toString(res));
		bw.flush();
	}
	
	static boolean check(int mid) {
		int cnt = 0;
		int tmp = mid;
		
		for(int i = 0; i < n; i++) {
			//mid값보다 arr[i]가 크면 false 반환
			if(mid < arr[i]) return false;
			tmp -= arr[i];
			//tmp가 음수가 되면 arr[i-1]까지 한 강의가 완성된 것이다.
			//그래서 다음 tmp는 mid - arr[i]로 설정하고 cnt++
			if(tmp < 0) {
				tmp = mid - arr[i];
				cnt++;
				continue;
			}
			//tmp가 딱 0이면 tmp를 mid로 설정하고 cnt++
			if(tmp == 0) {
				tmp = mid;
				cnt++;
				continue;
			}
		}
		//for문이 끝났는데 tmp와 mid 같지 않으면 강의 하나가 더 나온 것이라 cnt++
		if(tmp != mid) cnt++;
		
		//해당 mid값으로 cnt가 m개 이하가 되면 true로 반환 
		return m >= cnt;
		
	}
}
