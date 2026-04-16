import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static String[] word = {"h", "li","na","k","rb","cs","fr",
			"be","mg","ca","sr","ba","ra","sc","y","ti","zr",
			"hf","rf","la","ac","v","nb","ta","db","ce","th",
			"cr","mo","w","sg","pr","pa","mn","tc","re","bh","nd",
			"u","fe","ru","os","hs","pm","np","co","rh","ir","mt","sm",
			"pu","ni","pd","pt","ds","eu","am","cu","ag","au","rg","gd",
			"cm","zn","cd","hg","cn","tb","bk","b","al","ga","in","tl",
			"dy","cf","c","si","ge","sn","pb","fl","ho","es","n","p","as","sb",
			"bi","er","fm","o","s","se","te","po","lv","tm","md","f","cl","br",
			"i","at","yb","no","he","ne","ar","kr","xe","rn","lu","lr"};

	static String input;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			input = sc.next();
			flag = false;
			go(0);
			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	static void go(int idx) {
		boolean visited[] = new boolean[input.length()+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		visited[idx] = true;
		
		while(!q.isEmpty()) {
			int i = q.poll();
			if(i == input.length()) {
				flag = true;
				break;
			}
			
			String tmp1 = "", tmp2 = "";
			tmp1 += input.charAt(i);
			if(i+1 < input.length()) tmp2 += "" +input.charAt(i) + input.charAt(i+1);
//			System.out.println("tmp1 : " + tmp1 + " tmp2 : " + tmp2);
			for(int j = 0; j < word.length; j++) {
				if(tmp1.equals(word[j]) && !visited[i + 1]) {
					visited[i+1] = true;
					q.add(i+1);
				}
				if(i+1 < input.length() && tmp2.equals(word[j]) && !visited[i + 2]) {
					visited[i+2] = true;
					q.add(i + 2);
				}
			}
		}
	}
}