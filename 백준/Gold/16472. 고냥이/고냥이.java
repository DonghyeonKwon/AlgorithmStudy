import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		if(n == 26) {
			System.out.println(str.length());
			return;
		}
		
		int _maxLen = 0;
		int l = 0, r = 1;
		int[] check = new int['z' - 'a' + 1];
		int count = 0;
		
		//첫 글자 넣기
		check[str.charAt(l) - 'a']++;
		count++;
		
		//두번째 글자부터 시작
		while(r < str.length()) {
//			System.out.println("count : " + count + " l : " + l + " r : " + r );
//			System.out.println("l : " + l + " r : " + r);
//			System.out.println("count : " + count);
			// n 보다 count가 작을 떼
			if(count < n) {
				//해당 글자가 l~r사이에 포함되어 있지 않으면 count++;
				if(check[str.charAt(r) - 'a'] == 0) count++;
				check[str.charAt(r) - 'a']++;
				r++;
			}
			// n == count가 되면
			else {
//				System.out.println(str.charAt(r));
				//l~r 사이의 문자가 아니면
				if(check[str.charAt(r) - 'a'] == 0) {
					_maxLen = Math.max(_maxLen, r - l);
//					System.out.println(str.charAt(l));
					//왼쪽에 있는 글자 하나씩 빼기
					check[str.charAt(l) - 'a']--;
					//왼쪽에 있는 글자를 뺐는데 0이 되면
					if(check[str.charAt(l) - 'a'] == 0) {
						//정다 저장
						count--;
					}
					//이후 l++
					l++;
				}
				else {
					check[str.charAt(r) - 'a']++;
					r++;
				}
			}
//			System.out.println(r + " : " + _maxLen);
	
		}
		//마지막 정답 정리
		_maxLen = Math.max(_maxLen, str.length() - l);
		
		System.out.println(_maxLen);
	}
}