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
            switch(result.charAt(i)-'0') {
                case 0:
                    nums[0] += 1;
                    break;
                case 1:
                    nums[1] += 1;
                    break;
                case 2:
                    nums[2] += 1;
                    break;
                case 3:
                    nums[3] += 1;
                    break;
                case 4:
                    nums[4] += 1;
                    break;
                case 5:
                    nums[5] += 1;
                    break;
                case 6:
                    nums[6] += 1;
                    break;
                case 7:
                    nums[7] += 1;
                    break;
                case 8:
                    nums[8] += 1;
                    break;
                case 9:
                    nums[9] += 1;
                    break;
            }
        }
        for (int i=0; i<nums.length; i++){
            bw.write(nums[i] + "\n");
        }
        bw.flush();
    }
}