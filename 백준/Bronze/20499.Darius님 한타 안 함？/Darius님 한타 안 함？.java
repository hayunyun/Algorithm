import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        String str = br.readLine();
        String[] kda = str.split("/");
        if (Integer.parseInt(kda[0])+ Integer.parseInt(kda[2])< Integer.parseInt(kda[1]) | Integer.parseInt(kda[1])==0) {
            bw.write("hasu");
        } else bw.write("gosu");
        bw.flush();
        bw.close();
    }
}