import java.io.*;
import java.util.*;

class Info implements Comparable<Info> {
    int value, count;

    public Info(int val) {
        this.value = val;
        this.count = 1;
    }

    @Override
    public int compareTo(Info o) {
        if (o.count == this.count)
            return this.value - o.value;
        return o.count - this.count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N]; 
        Info[] infos = new Info[N];
        
        int sum = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }
    
        Arrays.sort(nums);

        for (int i = 0; i < N; i++) {
            if (i == 0)
                infos[i] = new Info(nums[i]);
            else {
                if (nums[i] == infos[i-1].value) {
                    infos[i-1].count += 1;
                    infos[i] = infos[i-1];
                }
                else
                    infos[i] = new Info(nums[i]);
            }
        }

        Arrays.sort(infos);
        
        // 평균
        bw.write(Math.round((float)sum/nums.length) + "\n");
        // // 중앙값
        bw.write(nums[nums.length/2] + "\n");
        // 최빈값
        if (infos[0].count < infos.length && infos[0].count == infos[infos[0].count].count) {
            bw.write(infos[infos[0].count].value + "\n");
        }
        else
            bw.write(infos[0].value + "\n");
        // 최대 - 최소
        bw.write(nums[nums.length-1] - nums[0] + "\n");

        bw.flush();
        bw.close();
    }
}