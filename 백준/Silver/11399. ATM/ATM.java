import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        int n = Integer.parseInt(br.readLine());
        int[] people = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people);

        int prev = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += prev + people[i];
            prev += people[i];
        }
        System.out.println(total);
    }
}