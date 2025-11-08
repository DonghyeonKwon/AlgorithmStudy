import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Time now = new Time(br.readLine().split(":"));
        Time start = new Time(br.readLine().split(":"));

        start.calc(now);
        System.out.print(start);
    }

    static class Time {
        int hour;
        int min;
        int sec;

        Time(String[] arr) {
            this.hour = Integer.parseInt(arr[0]);
            this.min = Integer.parseInt(arr[1]);
            this.sec = Integer.parseInt(arr[2]);
        }

        void calc(Time o) {
            if(o.sec > this.sec) {
                this.min -= 1;
                this.sec += 60;
            }
            this.sec -= o.sec;

            if(o.min > this.min) {
                this.hour -= 1;
                this.min += 60;
            }
            this.min -= o.min;

            if(o.hour > this.hour) {
                this.hour += 24;
            }
            this.hour -= o.hour;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if(hour < 10) {
                sb.append('0');
            }
            sb.append(hour).append(':');

            if(min < 10) {
                sb.append('0');
            }
            sb.append(min).append(':');

            if(sec < 10) {
                sb.append('0');
            }
            sb.append(sec);

            return sb.toString();
        }
    }
}
