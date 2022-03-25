import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] board;
    static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'W')
                    board[i][j] = true;
                else
                    board[i][j] = false;
            }
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }

    public static void find(int x, int y) {
        boolean TF = board[x][y]; // 첫번째 칸의 색
        int count = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (board[i][j] != TF)
                    count++; // 올바른 색이 아닐경우 count 1 증가 
                /* 
				 * 다음 칸은 색이 바뀌므로
				 * true라면 false로, false 라면 true 로
				 * 값을 변경한다.
				 */
				TF = !TF;
            }
            TF = !TF; // 한 줄 끝나면 또 값 변경
        }

        /*
		 *  첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
		 *  첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
		 *  색칠 할 개수(64 - count) 중 최솟값을 count 에 저장 
		 */
        count = Math.min(count, 64 - count);
        // 최솟값 도출
        min = Math.min(min, count);
    }
}