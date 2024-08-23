import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] res = new boolean[4];
		int[] match = new int[6];
		Team[] teams = new Team[6];
		
		for(int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 6; i++) {
				teams[i] = new Team(Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken()));
				match[i] |= (1 << i);
			}
			
			go(0, teams, res, match, t);
		}
		
		for(int i = 0; i < 4; i++) {
			System.out.print((res[i] ? 1 : 0) + " ");
		}
	}
	
	static void go(int idx, Team[] teams, boolean[] res, int[] match, int t) {
		if(idx == 6) {
			for(int i = 0; i < 6; i++) {
				if(match[i] != 63
				|| teams[i].w != 0
				|| teams[i].d != 0
				|| teams[i].l != 0) return;
			}
			
			res[t] |= true;
			
			return;
		}
		
		if(match[idx] == 63) {
			go(idx + 1, teams, res, match, t);
			return;
		}
		
//		for(int i = 0; i < 6; i++) {
//			System.out.println(teams[i].w + " " + teams[i].d + " " + teams[i].l);
//		}
		
		for(int i = 0; i < 6 && !res[t]; i++) {
			if((match[idx] & (1 << i)) > 0) continue;
			
			//idx 팀이 진 거
			if(teams[idx].l > 0 && teams[i].w > 0) {
				teams[idx].l--;
				teams[i].w--;
				
				match[idx] |= (1 << i);
				match[i] |= (1 << idx);
				
				go(idx, teams, res, match, t);
				
				match[idx] &= ~(1 << i);
				match[i] &= ~(1 << idx);
				
				teams[idx].l++;
				teams[i].w++;
			}
			
			//idx 팀이 비긴 거
			if(teams[idx].d > 0 && teams[i].d > 0) {
				teams[idx].d--;
				teams[i].d--;
				
				match[idx] |= (1 << i);
				match[i] |= (1 << idx);
				
				go(idx, teams, res, match, t);
				
				match[idx] &= ~(1 << i);
				match[i] &= ~(1 << idx);
				
				teams[idx].d++;
				teams[i].d++;
			}
			
			//idx 팀이 이긴 거
			if(teams[idx].w > 0 && teams[i].l > 0) {
				teams[idx].w--;
				teams[i].l--;

				match[idx] |= (1 << i);
				match[i] |= (1 << idx);
				
				go(idx, teams, res, match, t);
				
				match[idx] &= ~(1 << i);
				match[i] &= ~(1 << idx);
				
				teams[idx].w++;
				teams[i].l++;
			}
		}
		
	}
	
	static class Team{
		int w, d, l;
		Team(int w, int d, int l){
			this.w = w;
			this.d = d;
			this.l = l;
		}
	}
}
