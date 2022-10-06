import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    방향은 단방향
    로봇을 올리는 위치에 올리거나 / 어떤 칸으로 이동하면 칸의 내구도 1 감소
    1. 벨트가 한 칸 회전 && 벨트 위의 로봇도 한 칸 이동. 내리는 위치의 로봇은 내린다.
    2. 가장 먼저 벨트에 올라간 로봇부터 이동 가능 시 한 칸 이동. 이동 못하면 가마니.
        (로봇이 이동하기위해선 현재 칸이 내리는 위치가 아니고, 이동하려는 칸에 로봇이 없고, 내구도가 1 이상 남아있어야 함)
    3. 올리는 위치의 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
    4. 내구도가 0인 칸이 k개 이상이면 종료. 그렇지 않다면 1번부터 반복
     */
    static int n, k, level;
    static int[] belt;
    static boolean[] robot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[n * 2];
        robot = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n*2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int level = 1;
        while (true) {
            // 1. 컨베이어 벨트 회전 && 로봇 한 칸 이동
            turn();

            // 2. 올리는 위치의 로봇부터 한 칸 이동 가능 시 한 칸 이동 (이동하려는 칸에 로봇이 없고, 내구도 1 이상)
            move();

            //  3. 올리는 위치의 칸의 내구도가 0이 아니면 로봇을 올린다
            add();

            // 4. 내구도가 0인 칸이 k개 이상이면 종료. 그렇지 않다면 1번부터 반복
            if (count()) break;
            level++;
        }
        System.out.println(level);

    }

    // 컨베이어 벨트 회전
    static void turn() {
        int tmp = belt[n*2 - 1];
        for (int i = n*2 - 1; i > 0; i--) {
            belt[i] = belt[i-1];
            if (i < n - 1) { // n-1에 도착하면 즉시 내리므로, 범위에 포함시키지 않는다
                robot[i] = robot[i-1];
            }
        }

        belt[0] = tmp;
        robot[0] = false;
    }

    // 제일 먼저 올라간 위치의 로봇부터 한 칸 이동 가능 시 한 칸 이동 && 내구도 감소
    // (현재 칸에 로봇이 있고, 이동하려는 칸에 로봇이 없고, 내구도 1 이상)
    static void move() {
        for (int i = n - 2; i > 0; i--) {
            if (robot[i] && !robot[i+1] && belt[i+1] >= 1) {
                robot[i] = false;
                belt[i+1]--;
                if (i+1 == n - 1) continue;
                robot[i+1] = true;
            }
        }
    }

    // 올리는 위치의 칸의 내구도가 0이 아니면 로봇을 올린다
    static void add() {
        if (belt[0] > 0) {
            robot[0] = true;
            belt[0]--;
        }
    }

    static boolean count() {
        int cnt = 0;
        for (int i = 0; i < n * 2; i++) {
            if (belt[i] == 0) cnt++;
            if (cnt >= k) return true;
        }
        return false;
    }
}
