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
        String X = br.readLine();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i=0; i<X.length(); i++){
            if (arr[X.charAt(i)-97] == -1)
                arr[X.charAt(i) - 97] = i;
        }
        for (int i=0; i<arr.length; i++){
            bw.write(arr[i] + " ");
        }
        bw.flush();
    }
}