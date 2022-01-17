import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.HashSet;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(bf.readLine());
        int count = 0;
        if (N<100)
            count = N;
        else {
            count = 99;
            for (int i=100; i<=N; i++) {
                int num = i;
                HashSet<Integer> set = new HashSet<Integer>();
                while (num != 0) {
                    int one = num % 10;
                    int two = (num / 10) % 10;
                    if (two == 0)
                        break;
                    int distance = one - two;
                    set.add(distance);
                    num = num / 10;
                }
                if (set.size()==1)
                    count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }
}