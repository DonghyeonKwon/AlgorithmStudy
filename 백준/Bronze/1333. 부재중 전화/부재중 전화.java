import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int L = sc.nextInt();
		int D = sc.nextInt();
	
		List<Boolean> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < L; j++){
				list.add(true);
			}
			if(i != N-1){
				for(int j = 0; j < 5; j++){
					list.add(false);
				}
			}
		}
		int res = 0;
		while(res < list.size()){
			if(!list.get(res)){
				break;
			}
			res += D;
		}
		
		System.out.println(res);
	}
}