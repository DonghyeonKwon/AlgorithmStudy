import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int n, m, w;
    static List<Edge> list;
    static long[][] values;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while(t-->0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            values = new long[n+1][n+1];

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if(values[a][b] == 0 || values[a][b] > c) {
                    values[a][b] = values[b][a] = c;
                }
            }


            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(values[i][j] == 0 || values[i][j] == INF) continue;
                    list.add(new Edge(i, j, values[i][j]));
                }
            }

            Arrays.fill(values[0], INF);

            for(int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list.add(new Edge(a, b, -c));
                values[0][b] = 0;
            }


            boolean flag = false;
            for(int i = 0; i < n; i++) {
                for(Edge edge : list) {
                    if(values[0][edge.u] != INF && values[0][edge.v] > values[0][edge.u] + edge.c) {
                        values[0][edge.v] = values[0][edge.u] + edge.c;

                        if(i == n-1) {
                            flag = true;
                            break;
                        }
                    }

                }
            }

            if(flag) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }

    static class Edge {
        int u, v;
        long c;

        Edge(int u, int v, long c) {
            this.u = u;
            this.v = v;
            this.c = c;
        }

        public String toString() {
            return u + " " + v + " " + c;
        }
    }
}
