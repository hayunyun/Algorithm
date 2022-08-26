import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[9][9];
    static ArrayList<int[]> zeroPos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        zeroPos = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) zeroPos.add(new int[] {i, j});
            }
        }
        
        solve(0);
    }

    private static void solve(int cnt) {
        // 다 채우면 출력
        if (cnt == zeroPos.size()) {
            print();
            System.exit(0);
            return;
        }

        int[] now = zeroPos.get(cnt);
        for (int i = 1; i <= 9; i++) {
            map[now[0]][now[1]] = i;
            if (garoSero(now[0], now[1]) && nemo(now[0], now[1])) {
                solve(cnt + 1);
            }
            map[now[0]][now[1]] = 0;
        }
    }

    static boolean garoSero(int r, int c) {
        boolean[] garo = new boolean[10];
        boolean[] sero = new boolean[10];

        for (int j = 0; j < 9; j++) {
            if (map[r][j]==0) continue;
            if (garo[map[r][j]]) return false;
            garo[map[r][j]] = true;
        }

        for (int j = 0; j < 9; j++) {
            if (map[j][c]==0) continue;
            if (sero[map[j][c]]) return false;
            sero[map[j][c]] = true;
        }

        return true;
    }

    static boolean nemo(int r, int c) {
        boolean[] dag = new boolean[10];
        int lr = r / 3 * 3;
        int lc = c / 3 * 3;

        for (int i = lr; i < lr + 3; i++) {
            for (int j = lc; j < lc + 3; j++) {
                if (map[i][j] == 0) continue;
                if (dag[map[i][j]]) return false;
                dag[map[i][j]] = true;
            }
        }

        return true;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
