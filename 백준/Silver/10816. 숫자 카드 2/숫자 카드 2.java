import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();

       int n = Integer.parseInt(br.readLine());
       int[] cards = new int[n];
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");
       for (int i = 0; i < n; i++) {
           cards[i] = Integer.parseInt(st.nextToken());
        //    System.out.println(cards[i]);
       }

       Arrays.sort(cards);

       int m = Integer.parseInt(br.readLine());
       st = new StringTokenizer(br.readLine());
       for (int i = 0; i < m; i++) {
           int x = Integer.parseInt(st.nextToken());
           sb.append(upper(cards, x) - lower(cards, x)).append(' ');
       }
        System.out.println(sb);
    }

    // 중복값의 하한선
    public static int lower(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            // int mid = (low + high) / 2; // 오버플로우 위험
            int mid = low + (high - low) / 2; // 오버플로우 방지
            /*
			 *  key 값이 중간 위치의 값보다 작거나 같을 경우
			 *  
			 *  (중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.)
			 */
            if (key <= arr[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
            // System.out.println("lo");
        }
        return low;
    }

    // 중복값이 끝나고 처음 나오는 인덱스
    public static int upper(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            // int mid = (low + high) / 2; // 오버플로우 위험
            int mid = low + (high - low) / 2; // 오버플로우 방지
            if (key < arr[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}