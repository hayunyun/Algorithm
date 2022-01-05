import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
        int[] nums = new int[9];
        int max = nums[0];
        int loc = 0;
        for (int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (nums[i]>max) {
                max = nums[i];
                loc = i+1;
            }
        }
        bw.write(max + "\n" + loc + "\n");
        bw.flush();
    }
}