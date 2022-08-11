import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    static boolean[] visited;
    static int[] jumsu, cal;
    static int T, n, max, limit;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            max = 0;
            n = sc.nextInt();
            limit = sc.nextInt(); // 칼로리 한계

            jumsu = new int[n]; // 맛 점수
            cal = new int[n]; // 칼로리
            visited = new boolean[n];
//            ans = new int[n];

            for (int i = 0; i < n; i++) {
                jumsu[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }
            powerSet(0, 0);
//            recursive(0, 0, 0); // idx, 점수합, 칼로리합
            System.out.printf("#%d %d\n", tc, max);
        }
    }

    // power set
    private static void powerSet(int idx, int k) {
        if (idx > n) return;

        if (idx == n) {
            int jSum = 0; // 맛 점수 합
            int cSum = 0; // 칼로리합
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    jSum += jumsu[i];
                    cSum += cal[i];
                }
                if (cSum > limit) return;
            }
            max = Math.max(max, jSum);
            return;
        }

        // 넣는다
        visited[idx] = true;
        powerSet(idx + 1, k + 1);
        
        // 안 넣는다
        visited[idx] = false;
        powerSet(idx + 1, k);

    }

    // 조합
    private static void recursive(int idx, int jSum, int cSum) {
        // basis part
        if (cSum > limit) return;
        if (idx > n) return;
        // 모든 재료의 탐색이 끝났으면 점수 확인
        if (idx == n) {
            max = Math.max(max,  jSum);
//			System.out.println(cSum + ", " + jSum); // 칼로리가 안되는 한에서 가능한 맛의 합 출력
            return;
        }

        // logic + inductive part
        // 재료를 담는 경우
        recursive(idx + 1, jSum + jumsu[idx], cSum + cal[idx]);

        // 재료를 안 담는 경우
        recursive(idx + 1, jSum, cSum);
    }
}