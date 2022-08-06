import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, ans = 0;
    static int[] arr; // i번 행의 퀸은 arr[i]번에 놓음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        backTrack(0);
        System.out.println(ans);
    }

    // 한 행씩 순회
    static void backTrack(int depth) {
        if (depth == n) { // 0~n번 행에 대해 성공적으로 배치함
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) { // 열 순회
            // depth행 i열에 퀸을 놓을 수 있다면 진행
            boolean flag = true;

            // 0번째 행 ~ 현재행까지 가능한지 확인
            for (int j = 0; j < depth; j++) {
                if (attackable(depth, i, j, arr[j])) {
                    // 한번이라도 공격이 가능한 경우를 찾으면 더이상 볼 필요가 X
                    flag = false;
                    break;
                }
            }

            // 현재 배치가 가능한 경우 백트래킹
            if (flag) {
                arr[depth] = i;
                backTrack(depth + 1);
                arr[depth] = 0;
            }
        }
    }

    static boolean attackable(int r1, int c1, int r2, int c2) {
        // 행은 겹치지 않으니 패스

        // 같은 열
        if (c1 == c2) return true;

        // 대각선
        // 0,0  0,1  0,2
        // 1,0  1,1  1,2
        // 2,0  2,1  2,2
        if (Math.abs(r2 - r1) == Math.abs(c2 - c1)) return true;

        return false;
    }


}
