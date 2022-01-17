import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;
    char type;

    public Point(int y, int x, char type) {
        super();
        this.y = y;
        this.x = x;
        this.type = type;
    }
    @Override
    public String toString(){ return "y=" + y + "x=" + x + "type=" + type; }
}

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] dp; 
    static Queue<Point> q;
    static boolean foundAnswer;
    
    static final int[] MX = {-1, 1, 0, 0}; // 좌, 우
    static final int[] MY = {0, 0, -1, 1}; // 위, 아래
    
    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        dp = new int[R][C]; // 고슴도치의 경로 및 걸린 시간
        q = new LinkedList<>();

        Point start = null;

        for (int r = 0; r < R; r++) {
            String S = br.readLine();
            for (int c=0; c<C; c++) {
                map[r][c] = S.charAt(c);
                if (map[r][c] == 'S') { // 고슴도치일 경우
                    start = new Point(r, c, 'S');
                } else if (map[r][c]=='*') { //물이 있을 경우
                    q.add(new Point(r, c, '*'));
                }
            }
        }
        q.add(start); // 물 먼저 넣고 고슴도치 넣기

        while (!q.isEmpty()) {
            // 1. 큐에서 꺼내기 -> S, ., *, D 4가지 (돌은 X)
            Point p = q.poll();
            // 2. 목적지인가? -> D가 들어오면 목적지임
            if (p.type == 'D') {
                System.out.println(dp[p.y][p.x]);
                foundAnswer = true;
                break;
            }
            // 3. 연결된 곳을 순회 -> 좌, 우, 위, 아래
            for (int i = 0; i < 4; i++) {
                int ty = p.y + MY[i];
                int tx = p.x + MX[i];
                if (0 <= ty && ty < R && 0 <= tx && tx < C) { // 맵을 벗어나지 않는 구역이라면
                    // 4. 갈 수 있는가? -> 고슴도치 (맵을 벗어나지 않고, '.' 또는 D 구역, 방문하지 않은 곳)
                    if (p.type == '.' || p.type == 'S') { // 고슴도치
                        if ((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0) { // 빈곳이거나 목적지 && 아직 방문하지 않은 곳
                            // 5. 체크인 -> dp에 현재자리+1을 기록
                            dp[ty][tx] = dp[p.y][p.x] + 1;
                            // 6. 큐에 넣음
                            q.add(new Point(ty, tx, map[ty][tx]));
                        }
                    // 4. 갈 수 있는가? - 물 (맵을 벗어나지 않고, '.' 구역)
                    } else if (p.type == '*') { // 물
                        if (map[ty][tx] == '.') { // 물은 빈 곳으로만 이동
                            // 5. 체크인 -> 지도에 '*' 표기
                            map[ty][tx] = '*';
                            // 6. 큐에 넣음
                            q.add(new Point(ty, tx, '*'));
                        }
                    }
                }
            }
        }

        if (!foundAnswer) {
            bw.write("KAKTUS");
        }
        bw.flush();
    }
}
