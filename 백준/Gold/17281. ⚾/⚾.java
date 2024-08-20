import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static final int OUTCOUNT = 3;
  static int[][] arr;
  static int result;
  static int[] lineUp;
  static boolean[] selected = new boolean[9];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    result = 0;

    arr = new int[n][9];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < 9; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 중복 허용 안하고 순열
    lineUp = new int[9];
    selected = new boolean[9];
    lineUp[3] = 0; // 1번 선수는 4번 타자
    selected[0] = true; // 1번 선수(0번 인덱스)를 선택으로 표시
    select(0);

    System.out.println(result);
  }

  // 순열
  static void select(int idx) {
    if (idx == 9) {
      simulate(lineUp);
      return;
    }

    if (idx == 3) {
      select(idx + 1);
      return;
    } else {
      for (int i = 1; i < 9; i++) { // 1번 타자는 이미 배정됐으므로 1번부터 시작
        if (selected[i])
          continue;
        lineUp[idx] = i;
        selected[i] = true;
        select(idx + 1);
        selected[i] = false;
      }
    }
  }

  static void simulate(int[] lineUp) {
    int score = 0;
    int startPlayer = 0;

    // n 이닝
    for (int i = 0; i < n; i++) {
      int outCount = 0;
      boolean[] base = new boolean[4];

      while (outCount < OUTCOUNT) {
        int hitter = arr[i][lineUp[startPlayer]];
        switch (hitter) {
          case 0: // 아웃
            outCount++;
            break;
          case 1: // 1루타
            if (base[3]) {
              score++;
              base[3] = false;
            }
            if (base[2]) {
              base[3] = true;
              base[2] = false;
            }
            if (base[1]) {
              base[2] = true;
            }
            base[1] = true;
            break;
          case 2: // 2루타
            if (base[3]) {
              score++;
              base[3] = false;
            }
            if (base[2]) {
              score++;
              base[2] = false;
            }
            if (base[1]) {
              base[3] = true;
              base[1] = false;
            }
            base[2] = true;
            break;
          case 3: // 3루타
            if (base[3]) {
              score++;
              base[3] = false;
            }
            if (base[2]) {
              score++;
              base[2] = false;
            }
            if (base[1]) {
              score++;
              base[1] = false;
            }
            base[3] = true;
            break;
          case 4: // 홈런
            score += base[3] ? 1 : 0;
            score += base[2] ? 1 : 0;
            score += base[1] ? 1 : 0;
            score += 1;
            base[1] = base[2] = base[3] = false;
            break;
        }
        startPlayer++;
        if (startPlayer == 9) {
          startPlayer = 0;
        }
      }
    }
    result = Math.max(result, score);
  }
}
