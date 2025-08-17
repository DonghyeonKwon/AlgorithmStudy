import java.io.*;
import java.util.*;

public class Main {
    static int r, c, id = 1;
    static char[][] map;
    static int[][] idMap;
    static Map<Integer, List<int[]>> island = new HashMap<>();
    static List<Set<Integer>> g = new ArrayList<>();
    static List<List<Integer>> tree = new ArrayList<>();

    static int[] result;
    static int[] dy = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dx = {0, -1, 0, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        idMap = new int[r][c];
        for(int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        islandBfs();
        if(id == 1) {
            System.out.println(-1);
            return;
        }

        setGraph();
        result = new int[id];
        treeTraversal(0);

        int[] output= new int[c];
        for(int i = 1; i < result.length; i++) {
            int num = result[i];
            output[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < output.length && output[i] != 0; i++) {
            sb.append(output[i]).append(' ');
        }
        System.out.print(sb);
    }

    static void islandBfs() {
        boolean[][] visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(!visited[i][j] && map[i][j] == 'x') {
                    Queue<int[]> q = new ArrayDeque<>();
                    List<int[]> list = new ArrayList<>();

                    q.add(new int[] {i, j});
                    list.add(new int[] {i, j});
                    visited[i][j] = true;
                    idMap[i][j] = id;

                    while(!q.isEmpty()) {
                        int[] now = q.poll();

                        for(int d = 0; d < 8; d++) {
                            int ny = now[0] + dy[d];
                            int nx = now[1] + dx[d];

                            if(ny < 0|| ny >= r || nx < 0 || nx >= c) continue;
                            if(map[ny][nx]=='.') continue;
                            if(visited[ny][nx]) continue;

                            q.add(new int[]{ny, nx});
                            list.add(new int[]{ny, nx});
                            visited[ny][nx] = true;
                            idMap[ny][nx] = id;
                        }
                    }

                    island.put(id, list);
                    id++;
                }
            }
        }
    }

    static void setGraph() {
        for(int i = 1; i <= id; i++) {
            g.add(new HashSet<>());
        }

        for(int i = 1; i < id; i++) {
            List<int[]> posArr = island.get(i);

            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[r][c];
            q.addAll(posArr);
            for(int[] pos : posArr) {
                visited[pos[0]][pos[1]] = true;
            }

            while(!q. isEmpty()) {
                int[] now = q.poll();

                for(int d = 0; d < 4; d++) {
                    int ny = now[0] + dy[d];
                    int nx = now[1] + dx[d];

                    if(ny < 0 || ny >= r || nx < 0 || nx >= c) {
                        g.get(i).add(0);
                        g.get(0).add(i);
                        continue;
                    }

                    if(visited[ny][nx]) continue;
                    if(idMap[ny][nx] > 0) {
                        g.get(i).add(idMap[ny][nx]);
                        continue;
                    }

                    q.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }

        convertToTree();
    }

    static void convertToTree() {
        for(int i = 0; i <= id; i++) {
            tree.add(new ArrayList<>());
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[id + 1];

        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : g.get(now)) {
                if(!visited[next]) {
                    tree.get(now).add(next);

                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    static int treeTraversal(int now) {
        if(tree.get(now).isEmpty()) {
            result[now] = 0;
            return 0;
        }

        int max = 0;
        for (int next : tree.get(now)) {
            max = Math.max(max, treeTraversal(next));
        }

        result[now] = max + 1;
        return max + 1;
    }
}
