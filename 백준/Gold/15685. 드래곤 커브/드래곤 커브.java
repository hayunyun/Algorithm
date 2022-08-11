import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        // k세대 드래곤 커브는 k-1세대 드래곤 커브의 끝점을 기준으로 90도 시계방향 후 끝점에 붙인 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new boolean[101][101]; // 0~100
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 시작점 x
            int y = Integer.parseInt(st.nextToken()); // 시작점 y
            int d = Integer.parseInt(st.nextToken()); // 시작 방향 (0: x 우 / 1: y 상 / 2: x 좌 / 3: y 하)
            int g = Integer.parseInt(st.nextToken()); // 세대

            curve(x, y, d, g);
        }

        System.out.println(cntNemo());
    }

    // 드래곤 커브
    static void curve(int x, int y, int d, int g) {
        ArrayList<Integer> st = new ArrayList<>(); // 이전 세대의 방향 정보를 넣을 자료구조
        st.add(d);

        // 방향정보 담아주기
        for (int i = 1; i <= g; i++) { // 1 ~ g세대 정보 담기
            // 한 세대의 방향정보를 역순으로 탐색하며 +1을 시켜준 값이 다음 세대의 방향정보
            for (int j = st.size() - 1; j >= 0; j--) {
                int dir = st.get(j);
                dir = (dir + 1) % 4;
                st.add(dir);
            }
        }

        map[y][x] = true; // 0세대
        // 1세대 ~ g세대 방향정보 담은 순서대로 나아가기 (드래곤 커브는 격자 밖으로 벗어나지 않는다)
        for (int dir : st) {
            x += dx[dir];
            y += dy[dir];
            map[y][x] = true;
        }
    }
    
    // 사각형 개수 세기
    // 인접한 4칸이 모두 true라면 개수 1 증가
    static int cntNemo() {
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) {
                    result++;
                }
            }
        }
        return result;
    }
}
