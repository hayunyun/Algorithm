import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Stack;
// // import java.util.Arrays;
// // import java.util.Collection;
// import java.util.Collections;
// // import java.util.LinkedList;
// import java.util.List;
// import java.util.Comparator;
// import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n != 0) 
                stack.add(n);
            else
                stack.pop();
        }
        
        int sum = 0;
        for (int i = 0; i < stack.size(); i++) {
            sum += stack.get(i);
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}