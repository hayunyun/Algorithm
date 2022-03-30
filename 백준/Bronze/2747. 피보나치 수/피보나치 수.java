import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        // StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int [n+1];
        nums[0] = 0;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }

        System.out.println(nums[n]);
    }
}