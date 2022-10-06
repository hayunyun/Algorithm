import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, minScore, minPerson;
    static ArrayList<Integer>[] people;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        people = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            people[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!people[a].contains(b)) {
                people[a].add(b);
                people[b].add(a);
            }
        }

        minScore = Integer.MAX_VALUE;
        minPerson = -1;
        game();
        System.out.println(minPerson);
    }

    static void game() {
        for (int i = 1; i <= n; i++) {
            int score = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                score += bfs(i, j);
            }

            if (score < minScore) {
                minScore = score;
                minPerson = i;
            }
        }
    }

    static int bfs(int start, int end) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(start, 0));

        while (!q.isEmpty()) {
            Info i = q.poll();

            if (i.to == end) return i.score;

            for (int p : people[i.to]) {
                q.add(new Info(p, i.score + 1));
            }
        }

        return 0;
    }

    static class Info {
        int to, score;

        public Info(int to, int score) {
            this.to = to;
            this.score = score;
        }
    }
}
