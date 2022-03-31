import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int n = Integer.parseInt(br.readLine());
        int[] budgets = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        System.out.println(search(m, budgets));
    }

    static int search(int m, int[] budgets) {
        int answer = 0;
        Arrays.sort(budgets);

        int max = budgets[budgets.length - 1];
        int min = 0;

        while (min <= max) {
            int currentTotal = 0; // 현재 예상 총액
            int maxTotal = 0; // 여태껏 가장 최대 예산
            int mid = (min + max) / 2;
            for (int budget : budgets) {
                currentTotal += (budget < mid ? budget : mid);
            }
            if (currentTotal < m) {
            // 가능한 한 최대의 총 예산 = 예산 - 배정된 예상이 가장 작은 값
                if (m - currentTotal < m - maxTotal) {
                    maxTotal = currentTotal;
                    answer = mid;
                }
                min = mid + 1;
            }
            else if (currentTotal > m) {
                max = mid - 1;
            }
            else return mid;
        }
        return answer;

    }
}