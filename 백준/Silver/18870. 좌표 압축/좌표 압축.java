import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine()); 
        int min = Integer.MAX_VALUE;

        int[] nums = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            min = Integer.min(min, nums[i]);
        }

        int[] rankList = nums.clone();
        Arrays.sort(rankList);

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(rankList[0], 0);
        int cnt = 1;
        for (int i = 1; i < rankList.length; i++) {
            if (rankList[i] == rankList[i-1])
                map.put(rankList[i], map.get(rankList[i-1]));
            else {
                map.put(rankList[i], cnt);
                cnt++;
            }
        }

        for (int num : nums)
            sb.append(map.get(num) + " ");
        System.out.println(sb);

    }
}