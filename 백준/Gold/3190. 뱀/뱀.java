import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    뱀은 맨 위 좌측에서 시작, 길이는 1, 오른쪽 보고 있음
    매 초마다 몸길이를 늘려 머리를 다음칸에 위치
    - 이동한 칸에 사과가 있다면 사과가 없어지고 꼬리는 움직이지 않음 (= 몸길이가 1 늘어남)
    - 이동한 칸에 사과가 없다면 몸길이를 줄여 꼬리가 위치한 칸을 비움 (= 몸길이는 변하지 않음)

    사과를 먹으면 길이가 늘어남
    뱀이 벽 또는 자기자신과 부딪히면 게임이 끝남
     */

    static int n;
    static int[][] map;
    static Deque<int[]> deque = new LinkedList<>();
    static Queue<Integer> turnTime = new LinkedList<>();
    static Queue<String> turnDir = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        deque.add(new int[] {0, 1}); // 우
        deque.add(new int[] {1, 0}); // 하
        deque.add(new int[] {0, -1}); // 좌
        deque.add(new int[] {-1, 0}); // 상

        // input
        n = Integer.parseInt(br.readLine()); // 맵의 크기는 n * n
        map = new int[n][n];

        int k = Integer.parseInt(br.readLine()); // 사과의 크기
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            // 사과는 r행 c열에 있다
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 4;
        }

        int l = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 정보
        for (int i = 0; i < l; i++) {
            // x초가 지난 뒤 90도 방향 회전 (L: 왼쪽, D: 오른쪽)
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            turnTime.add(x);
            turnDir.add(c);
        }


        game(0, 0);
    }

    static void game(int snakeR, int snakeC) {
        int time = 0;
        map[snakeR][snakeC] = 1;
        int r = snakeR;
        int c = snakeC;
        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[] {r, c});

        while (true) {
            time++;
            int[] dir = deque.peek();
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) break;

            // 1. 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
            snake.addFirst(new int[] {nr, nc});
            // 1-1. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
            if (map[nr][nc] == 4) {
                map[nr][nc] = 1;
            }
            // 1-2. 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
            else if (map[nr][nc] == 0){
                map[nr][nc] = 1;
                int[] pre = snake.pollLast();
                map[pre[0]][pre[1]] = 0;
            }
            // 본인의 몸과 부딪히면 게임 종료
            else if (map[nr][nc] == 1) {
                break;
            }

            // x초가 끝난 뒤에 90도 회전
            if (!turnTime.isEmpty() && time == turnTime.peek()) {
                turnTime.poll();
                String d = turnDir.poll();
                switch (d) {
                    case "D": // 우회전
                        int[] pre = deque.poll();
                        deque.add(pre);
                        break;
                    case "L": // 좌회전
                        pre = deque.pollLast();
                        deque.addFirst(pre);
                        break;
                }
            }

            r = nr;
            c = nc;
        }

        System.out.println(time);
    }
}
