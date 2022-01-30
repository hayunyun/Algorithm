import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  

        int[] nums = new int[7];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < 7; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (nums[i]%2 == 1) {
                sum += nums[i];
                min = Integer.min(min, nums[i]);
            }
        }

        if (sum==0) {
            bw.write(-1 + "\n");
        }
        else {
            bw.write(sum + "\n");
            bw.write(String.valueOf(min));
        }
        bw.flush();
        bw.close();
    }
}