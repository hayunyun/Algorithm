import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        ArrayList<Integer> arr_x = new ArrayList<>();
        ArrayList<Integer> arr_y = new ArrayList<>();
        for (int i = 0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (arr_x.contains(x)) {
                arr_x.remove(Integer.valueOf(x));
            }
            else {
                arr_x.add(x);
            }

            if (arr_y.contains(y)) {
                arr_y.remove(Integer.valueOf(y));
            }
            else {
                arr_y.add(y);
            }
        }

        bw.write(arr_x.get(0) + " " + arr_y.get(0));
        bw.flush();
    }
}