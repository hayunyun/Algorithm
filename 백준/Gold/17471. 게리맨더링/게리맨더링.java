import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] region;
    static HashMap<Integer, Integer> info;
    static boolean[] isA;
    static int n, min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        region = new int[n+1][];

        // 구역별 인구 정보 저장
        info = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            info.put(i, Integer.parseInt(st.nextToken()));
        }

        // 구역별 연결된 구역 저장
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            region[i] = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 두 구역으로 나눈다
        // 2. 가능한 방법인지 확인
        // 3. 인구의 최소 차이 저장

        isA = new boolean[n+1];
        divide(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        // 확인
//        for (int[] nums : region) {
//            for (int num : nums)
//                System.out.print(num + " ");
//            System.out.println();
//        }
    }

    static void divide(int idx, int k) {
        if (idx == n) {
            if (isConnect()) {
//                for (int i = 1; i <= n; i++) {
//                    if (isA[i]) System.out.print(i + " ");
//                }
//                System.out.println();
                int sumA = 0; int sumB = 0;
                for (int i = 1; i <= n; i++) {
                    if (isA[i]) {
                        sumA += info.get(i);
                    } else {
                        sumB += info.get(i);
                    }
                }
                min = Math.min(min, Math.abs(sumA - sumB));
            }
            return;
        }

        isA[idx] = true;
        divide(idx + 1, k + 1);

        isA[idx] = false;
        divide(idx + 1, k);
    }

    // A구역 B구역 각각 BFS
    static boolean isConnect() {
        // A구역 하나 찾기
        int cntA = -1;
        for (int i = 1; i <= n; i++) {
            if (isA[i]) {
                cntA = i;
                break;
            }
        }

        // B구역 하나 찾기
        int cntB = -1;
        for (int i = 1; i <= n; i++) {
            if (!isA[i]) {
                cntB = i;
                break;
            }
        }

        if (cntA == -1 || cntB == -1) return false;

        boolean[] visited = new boolean[n+1];

        // A 연결 확인
        Queue<Integer> qA = new LinkedList<>();
        qA.add(cntA);
        visited[cntA] = true;
        while (!qA.isEmpty()) {
            int now = qA.poll();
            for (int area : region[now]) {
                if (!visited[area] && isA[area]) {
                    qA.add(area);
                    visited[area] = true;
                }
            }
        }

        // B 연결 확인
        Queue<Integer> qB = new LinkedList<>();
        qB.add(cntB);
        visited[cntB] = true;
        while (!qB.isEmpty()) {
            int now = qB.poll();
            for (int area : region[now]) {
                if (!visited[area] && !isA[area]) {
                    qB.add(area);
                    visited[area] = true;
                }
            }
        }

        // 한곳이라도 연결되지 않았다면
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}
