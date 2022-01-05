import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        String result = Integer.toString(A*B*C);

        int[] nums = new int[10];
        Arrays.fill(nums, 0);
        for (int i=0; i<result.length(); i++) {
            nums[result.charAt(i)-'0']++;
        }
        for (int i=0; i<nums.length; i++){
            bw.write(nums[i] + "\n");
        }
        bw.flush();
    }
}
