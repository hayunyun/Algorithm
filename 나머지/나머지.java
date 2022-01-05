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

        int[] nums = new int[10];
        int count = 10;
        for (int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine()) % 42; 
        }
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i]==nums[j]) {
                    count -= 1;
                    break;
                }
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }
}