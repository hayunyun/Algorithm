import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int[] cnt;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char [n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        max = 0;
        // 양옆 바꾸기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, j);
                // 사탕 최대 개수 확인
                max = check(n);
                // 원위치
                swap(i, j);
            }
        }

        // 상하 바꾸기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                updn(j, i);
                // 사탕 최대 개수 확인
                max = Math.max(max, check(n));
                // 원위치
                updn(j, i);
            }
        }

        System.out.println(max);
    }

    // 좌우 바꾸기
    static void swap(int i, int j) {
        char temp = map[i][j];
        map[i][j] = map[i][j + 1];
        map[i][j + 1] = temp;
    }

    // 상하 바꾸기
    static void updn(int i, int j) {
        char temp = map[i][j];
        map[i][j] = map[i + 1][j];
        map[i + 1][j] = temp;
    }

    // 최대 사탕 찾기
    static int check(int n) {
        // 가로
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        // 세로
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (map[j][i] == map[j + 1][i]) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}