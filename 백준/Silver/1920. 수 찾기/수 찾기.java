import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = search(Integer.parseInt(st.nextToken()), nums);
            sb.append(x).append("\n");
        }

        System.out.println(sb);  
        
    }

    public static int search(int m, int[] nums) throws IOException {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (m < nums[mid]) {
                high = mid - 1;
            }
            else if (m > nums[mid]) {
                low = mid + 1;
            }
            else return 1;
        }
        return 0;
    }
}