import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int T = Integer.parseInt(br.readLine());
        for (int l=0; l<T; l++){
            int k = Integer.parseInt(br.readLine()) + 1; //층
            int n = Integer.parseInt(br.readLine()); //호
            int[][] apt = new int[k][n];
            for (int i=0; i<k; i++) { // 층
                for (int j=0; j<n; j++) { // 호
                    if (i==0){ // 0층일 경우에는 값 그대로 넣기
                        apt[i][j] += j+1;
                    }
                    else { // 0층 이상일 경우
                        for (int z=0; z<=j; z++) {
                            apt[i][j] += apt[i-1][z];
                        }
                    }
                    // bw.write(apt[i][j] + " ");
                }
                // bw.write("\n");
            }
            bw.write(apt[k-1][n-1]+"\n");
            bw.flush();
        }
    }
}