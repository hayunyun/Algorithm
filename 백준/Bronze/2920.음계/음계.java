import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        String nums = br.readLine();
        String[] num = nums.split(" ");
        boolean[] check = new boolean[7];
        String ans = " ";
        int cnt = 0;
        for (int i=1; i<num.length; i++) {
            int temp = Integer.parseInt(num[i-1]);
            if (temp<Integer.parseInt(num[i])) {
                check[i-1] = true;
            }
            else if (temp>Integer.parseInt(num[i])) {
                check[i-1] = false;
            }
            cnt += (check[i-1] ? 1 : 0);
        }
        if (cnt == 7) 
            ans = "ascending";
        else if (cnt == 0) 
            ans = "descending";
        else
            ans = "mixed";
        bw.write(ans);
        bw.flush();
        }
}