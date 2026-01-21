import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            User user = new User(Integer.parseInt(st.nextToken()), st.nextToken());

            boolean needRoom = true;
            for(Room room : list) {
                if(room.list.size() >= m) continue;
                if(!(Math.abs(room.level - user.l) <= 10)) continue;

                room.list.add(user);
                needRoom = false;
                break;
            }

            if(needRoom) {
                list.add(new Room(user));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Room room : list) {
            if(room.list.size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }

            Collections.sort(room.list);
            for(User user : room.list) {
                sb.append(user).append('\n');
            }
        }

        System.out.print(sb);
    }

    static class Room {
        int level;
        List<User> list;

        Room(User u) {
            this.level = u.l;
            this.list = new ArrayList<>();
            list.add(u);
        }
    }

    static class User implements Comparable<User> {
        int l;
        String nickname;

        User(int l, String nickname) {
            this.l = l;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return this.l + " " + this.nickname;
        }

        @Override
        public int compareTo(User o) {
            return this.nickname.compareTo(o.nickname);
        }
    }
}
