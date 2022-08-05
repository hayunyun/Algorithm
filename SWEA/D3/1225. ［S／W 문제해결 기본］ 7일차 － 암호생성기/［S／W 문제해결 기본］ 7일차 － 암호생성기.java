import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        // 사이클 계속 반복
        // 0보다 작아지거나 0일 경우 0으로 저장되며, 해당 숫자 배열이 암호가 됨
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                q.add(sc.nextInt());
            }

            int cnt = 1;
            while (true) {
                int first = q.poll();
                int next = first - cnt++;
                if (next <= 0) {
                    q.add(0);
                    break;
                }
                else {
                    q.add(next);
                }

                if (cnt > 5) cnt = 1;
            }

            System.out.printf("#%d ", tc);
            for (int n : q) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
