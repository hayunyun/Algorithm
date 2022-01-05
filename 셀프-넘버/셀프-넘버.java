import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException; 

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        Boolean[] arr = new Boolean[10000];
        for (int i=1; i<=10000; i++) {
            int ans = i + i/1000 + (i%1000)/100 + ((i%1000)%100)/10 + ((i%1000)%100)%10;
            if (ans<=10000)
                arr[ans-1] = true;
        }
        for (int i=0; i<10000; i++) {
            if (arr[i] == null)
                bw.write(i+1 + "\n");
        }
        bw.flush();
    }
}