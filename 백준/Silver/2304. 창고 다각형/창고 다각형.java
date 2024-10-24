import java.io.*;
import java.util.*;


/**
 * 첫번째 인자기준 정렬
 * 차례대로 반복문
 * 다음번 두번쨰 인자의 값이 이전 두번째 인자의 값보다 크다면 그 높이만큼 더한다.
 */
public class Main {

    static int N;
    static ArrayList<int[]> infos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] pos = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            infos.add(pos);
        }

        Collections.sort(infos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int state = Integer.compare(o1[0], o2[0]);
                if (state == 0) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int mid = 0;
        int midIdx = 0;
        for (int i = 0; i < N; i++) {
            if (mid < infos.get(i)[1]) {
                mid = infos.get(i)[1];
                midIdx = i;
            }
        }  // 최대 높이, 최대 높이 인덱스 추출

        int answer = 0;
        int curLt = infos.get(0)[0], curHeight = infos.get(0)[1];
        for (int i = 0; i < midIdx; i++) {
            int nextLt = infos.get(i + 1)[0];
            int nextHeight = infos.get(i + 1)[1];

            if (nextHeight >= curHeight) {
                answer += (nextLt - curLt) * curHeight;
                curLt = nextLt;
                curHeight = nextHeight;
            }
        }

        answer += mid;

        curLt = infos.get(N-1)[0];
        curHeight = infos.get(N-1)[1];
        for (int i = N - 1; i > midIdx; i--) {
            int nextLt = infos.get(i - 1)[0];
            int nextHeight = infos.get(i - 1)[1];

            if (nextHeight >= curHeight) {
                answer += (curLt - nextLt) * curHeight;
                curLt = nextLt;
                curHeight = nextHeight;
            }
        }

        System.out.println(answer);
    }
}