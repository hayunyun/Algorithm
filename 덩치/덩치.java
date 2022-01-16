import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];
        int ans[] = new int[N];
        
        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<=1; j++) {
                arr[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++){
            int wgt = arr[i][0];
            int hgt = arr[i][1];
            int cnt = 0;
            for (int j=0; j<N; j++) {
                if (i==j) continue;
                else {
                    if (wgt<arr[j][0]) { //비교대상보다 크다면
                        if (hgt<arr[j][1]) cnt++;
                        else continue;
                    }
                }
            }
            ans[i] = cnt+1;
        }
        
        for (int obj : ans)
            bw.write(obj + " ");
        
        bw.write("\n");
        bw.flush();
    }
}