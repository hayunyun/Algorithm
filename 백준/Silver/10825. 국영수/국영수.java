import java.io.*;
import java.util.*;

public class Main {
    static class Info implements Comparable<Info> {
        String name;
        int ko, en, ma;

        public Info(String _name, int _ko, int _en, int _ma) {
            this.name = _name;
            this.ko = _ko;
            this.en = _en;
            this.ma = _ma;
        }

        @Override
        public int compareTo(Info o) {
            if (this.ko == o.ko) {
                if (this.en == o.en) {
                    if (this.ma == o.ma) {
                        return this.name.compareTo(o.name);
                    }
                    return o.ma - this.ma;
                }
                return this.en - o.en;
            }
            return o.ko - this.ko;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Info[] students = new Info[n];
        for (int i = 0; i < n; i++) {
            String[] x = br.readLine().split(" ");
            students[i] = (new Info(x[0], Integer.parseInt(x[1]), Integer.parseInt(x[2]), Integer.parseInt(x[3])));
        }

        // 국 감소 -> 영어 증가 -> 수학 감소 -> 이름 사전순
        Arrays.sort(students);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(students[i].name).append("\n");
        }
        System.out.println(sb);
    }
}