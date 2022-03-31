import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mon = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        for (int i = 1; i < mon; i++) {
            day += month[i-1];
        }

        System.out.println(days[day % 7]);
    }
}