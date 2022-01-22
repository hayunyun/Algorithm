import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        
        int N = Integer.parseInt(br.readLine());
        
        Stack ans = new Stack();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String mtd = st.nextToken();
    
            int answer = 0;
    
            if (mtd.equals("push")) {
                int M = Integer.parseInt(st.nextToken()); 
                ans.push(M);
                continue;
            }
            else if (mtd.equals("pop")) answer = ans.pop();
            else if (mtd.equals("size")) answer = ans.size();
            else if (mtd.equals("empty")) answer = ans.empty();
            else if (mtd.equals("top")) answer = ans.top();
            
            bw.write(answer + "\n");
            bw.flush();
        }
    }
}

class Stack {
    ArrayList<Integer> stck = new ArrayList<>();
    
    public void push(int x) {
        stck.add(x);
    }

    public int pop() {
        int out;
        if (stck.size() > 0) 
            out = stck.remove(stck.size()-1);
        else
            out = -1;
        return out;
    }

    public int size() {
        return stck.size();
    }

    public int empty() {
        if (stck.size() > 0)
            return 0;
        else return 1;
    }

    public int top() {
        int out;
        if (stck.size() > 0) 
            out = stck.get(stck.size()-1);
        else
            out = -1;
        return out;
    }
}