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

        int N = Integer.parseInt(br.readLine());
        String [] arr = new String[N];
        for (int i=0; i<arr.length; i++) {
            arr[i] = br.readLine();
            int count = 0;
            int sum = 0;
            for (int j=0; j<arr[i].length(); j++) {
                if (arr[i].charAt(j)=='O') {
                    count += 1;
                    sum += count;
                }
                if (arr[i].charAt(j)=='X') {
                    count = 0;
                }
            }
            bw.write(sum + "\n");
        }
        bw.flush();
    }
}